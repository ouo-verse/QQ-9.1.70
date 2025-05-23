package com.tencent.robot.adelie.homepage.create;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BotGender;
import com.tencent.qqnt.kernel.nativeinterface.ChangeMyBotOperationType;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotActivityLabel;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView;
import com.tencent.robot.adelie.homepage.create.view.AdelieGenderPickerView;
import com.tencent.robot.adelie.homepage.create.view.AdelieSettingEditView;
import com.tencent.robot.adelie.homepage.create.view.InterceptTouchEditText;
import com.tencent.robot.api.IRobotInfoUpdateService;
import com.tencent.robot.api.IRobotProfileInfoApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0014\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0016J.\u0010\u001c\u001a\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0014J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0002H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/AdelieEditFragment;", "Lcom/tencent/robot/adelie/homepage/create/AdelieCreationFragment;", "", "Jk", "Kk", "", "isAllowLandscape", "", "Kh", "Lcom/tencent/qqnt/kernel/nativeinterface/MyBotInfo;", "botInfo", "Xi", "", "getPageType", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Lcom/tencent/qqnt/kernel/nativeinterface/ChangeMyBotOperationType;", "zj", "errCode", "Yj", "Lmqq/util/WeakReference;", "weakFragment", "errMsg", "Ak", "zk", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Gh", "onFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Dialog;", "F0", "Landroid/app/Dialog;", "deleteLoadingDialog", "Ljava/lang/Runnable;", "G0", "Ljava/lang/Runnable;", "hideLoadingDialogRunnable", "", "H0", "J", "genStartTime", "I0", "Ljava/lang/String;", "uid", "<init>", "()V", "J0", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieEditFragment extends AdelieCreationFragment {

    /* renamed from: J0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: F0, reason: from kotlin metadata */
    @Nullable
    private Dialog deleteLoadingDialog;

    /* renamed from: G0, reason: from kotlin metadata */
    @Nullable
    private Runnable hideLoadingDialogRunnable;

    /* renamed from: H0, reason: from kotlin metadata */
    private long genStartTime;

    /* renamed from: I0, reason: from kotlin metadata */
    @NotNull
    private String uid = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/AdelieEditFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "a", "", "EDIT_ROBOT_UID", "Ljava/lang/String;", "KUIKLY_EVENT", "PAGE_DATA", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.create.AdelieEditFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent intent) {
            Activity activity;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            AdelieFragmentActivity.INSTANCE.a(context, intent, AdelieEditFragment.class);
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                activity.overridePendingTransition(R.anim.f155068vk, R.anim.f155078vu);
            }
        }

        Companion() {
        }
    }

    private final void Jk() {
        String str;
        boolean z16;
        String str2;
        JSONObject k06;
        Intent intent;
        Intent intent2;
        FragmentActivity activity = getActivity();
        String str3 = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            str = intent2.getStringExtra("editRobotUid");
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        this.uid = str;
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                str2 = intent.getStringExtra(ISchemeApi.KEY_PAGE_DATA);
            } else {
                str2 = null;
            }
            if (str2 != null && (k06 = KRCSSViewExtensionKt.k0(str2)) != null) {
                str3 = k06.getString("uid");
            }
            if (str3 != null) {
                str4 = str3;
            }
            this.uid = str4;
            if (str4.length() == 0) {
                z17 = true;
            }
            if (z17) {
                QLog.e("AdelieCreationFragment", 1, "requestData empty uid");
                return;
            }
        }
        Lh().m2(this.uid, new Function3<Integer, String, MyBotInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieEditFragment$requestData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str5, MyBotInfo myBotInfo) {
                invoke(num.intValue(), str5, myBotInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, @NotNull MyBotInfo botInfo) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(botInfo, "botInfo");
                QLog.i("AdelieCreationFragment", 1, "requestData callback errCode:" + i3 + ", errMsg:" + errMsg);
                if (i3 != 0) {
                    if (i3 == 30099) {
                        AdelieEditFragment.this.Kk();
                    } else {
                        AdelieEditFragment.this.ci(i3, errMsg);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kk() {
        final MyBotInfo value = Lh().h2().getValue();
        if (value != null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u8be5\u667a\u80fd\u4f53\u5df2\u5220\u9664\uff0c\u65e0\u6cd5\u518d\u6b21\u8fdb\u884c\u7f16\u8f91", (String) null, "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.ac
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AdelieEditFragment.Lk(MyBotInfo.this, this, dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026       null\n            )");
            createCustomDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.robot.adelie.homepage.create.ad
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                    boolean Mk;
                    Mk = AdelieEditFragment.Mk(dialogInterface, i3, keyEvent);
                    return Mk;
                }
            });
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lk(MyBotInfo it, AdelieEditFragment this$0, DialogInterface dialogInterface, int i3) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.robot.adelie.homepage.g.f366352a.a().postValue(new a24.i(ChangeMyBotOperationType.KDELETE, it));
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null && !activity2.isFinishing() && (activity = this$0.getActivity()) != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Mk(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment
    public void Ak(@NotNull WeakReference<AdelieCreationFragment> weakFragment, final int errCode, @NotNull final String errMsg, @NotNull MyBotInfo botInfo) {
        Intrinsics.checkNotNullParameter(weakFragment, "weakFragment");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieEditFragment$updateViewAfterCreation$1
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
                int i3 = errCode;
                if (i3 == 0) {
                    ae.f366120a.c();
                    FragmentActivity activity = this.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                if (i3 == 30099) {
                    this.Kk();
                } else {
                    this.ci(i3, errMsg);
                    this.xk();
                }
            }
        });
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieBaseFragment
    @Nullable
    public com.tencent.biz.qui.quisecnavbar.a Gh() {
        return null;
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment, com.tencent.robot.adelie.homepage.create.AdelieBaseFragment
    @NotNull
    public String Kh() {
        return "\u7f16\u8f91\u667a\u80fd\u4f53";
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment
    public void Xi(@NotNull final MyBotInfo botInfo) {
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieEditFragment$botInfoObserver$1
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
                long j3;
                TextView promptConversationName;
                TextView ttsNameView;
                InterceptTouchEditText nicknameEditText;
                AdelieEditTextView descView;
                AdelieEditTextView openMarkView;
                AdelieSettingEditView settingView;
                String str = MyBotInfo.this.botPrompt;
                Intrinsics.checkNotNullExpressionValue(str, "botInfo.botPrompt");
                boolean z16 = false;
                if ((str.length() > 0) && (settingView = this.getSettingView()) != null) {
                    String str2 = MyBotInfo.this.botPrompt;
                    Intrinsics.checkNotNullExpressionValue(str2, "botInfo.botPrompt");
                    settingView.setEditText(str2);
                }
                String str3 = MyBotInfo.this.botWelcomeMsg;
                Intrinsics.checkNotNullExpressionValue(str3, "botInfo.botWelcomeMsg");
                if ((str3.length() > 0) && (openMarkView = this.getOpenMarkView()) != null) {
                    String str4 = MyBotInfo.this.botWelcomeMsg;
                    Intrinsics.checkNotNullExpressionValue(str4, "botInfo.botWelcomeMsg");
                    openMarkView.setEditText(str4);
                }
                String str5 = MyBotInfo.this.botDesc;
                Intrinsics.checkNotNullExpressionValue(str5, "botInfo.botDesc");
                if ((str5.length() > 0) && (descView = this.getDescView()) != null) {
                    String str6 = MyBotInfo.this.botDesc;
                    Intrinsics.checkNotNullExpressionValue(str6, "botInfo.botDesc");
                    descView.setEditText(str6);
                }
                String str7 = MyBotInfo.this.botName;
                Intrinsics.checkNotNullExpressionValue(str7, "botInfo.botName");
                if ((str7.length() > 0) && (nicknameEditText = this.getNicknameEditText()) != null) {
                    nicknameEditText.setText(Editable.Factory.getInstance().newEditable(MyBotInfo.this.botName));
                }
                String str8 = MyBotInfo.this.ttsName;
                Intrinsics.checkNotNullExpressionValue(str8, "botInfo.ttsName");
                if ((str8.length() > 0) && (ttsNameView = this.getTtsNameView()) != null) {
                    ttsNameView.setText(MyBotInfo.this.ttsName);
                }
                Intrinsics.checkNotNullExpressionValue(MyBotInfo.this.robotPromptConversationList, "botInfo.robotPromptConversationList");
                if ((!r0.isEmpty()) && (promptConversationName = this.getPromptConversationName()) != null) {
                    promptConversationName.setText("\u5df2\u8bbe\u5b9a");
                }
                Context context = this.getContext();
                if (context != null) {
                    AdelieEditFragment adelieEditFragment = this;
                    RelativeLayout promptConversationContainer = adelieEditFragment.getPromptConversationContainer();
                    if (promptConversationContainer != null) {
                        promptConversationContainer.setClickable(true);
                    }
                    TextView promptConversationName2 = adelieEditFragment.getPromptConversationName();
                    if (promptConversationName2 != null) {
                        promptConversationName2.setTextColor(context.getColor(R.color.qui_common_text_primary));
                    }
                }
                AdelieGenderPickerView genderView = this.getGenderView();
                if (genderView != null) {
                    BotGender botGender = MyBotInfo.this.botGender;
                    Intrinsics.checkNotNullExpressionValue(botGender, "botInfo.botGender");
                    genderView.m(botGender);
                }
                ArrayList<RobotActivityLabel> arrayList = MyBotInfo.this.robotActivityLabelList;
                if (!(arrayList == null || arrayList.isEmpty())) {
                    RobotActivityLabel robotActivityLabel = MyBotInfo.this.robotActivityLabelList.get(0);
                    if (robotActivityLabel.join) {
                        AdelieEditFragment adelieEditFragment2 = this;
                        String str9 = robotActivityLabel.f359208id;
                        if (str9 == null) {
                            str9 = "";
                        }
                        adelieEditFragment2.pk(str9);
                        AdelieEditFragment adelieEditFragment3 = this;
                        String str10 = robotActivityLabel.name;
                        adelieEditFragment3.qk(str10 != null ? str10 : "");
                        this.bk();
                    }
                }
                this.Ek(true);
                String str11 = MyBotInfo.this.botAvatar;
                if (str11 != null) {
                    if (str11.length() > 0) {
                        z16 = true;
                    }
                }
                if (z16) {
                    AdelieEditFragment adelieEditFragment4 = this;
                    String str12 = MyBotInfo.this.botAvatar;
                    Intrinsics.checkNotNullExpressionValue(str12, "botInfo.botAvatar");
                    j3 = this.genStartTime;
                    adelieEditFragment4.vk(str12, j3, QCircleDaTongConstant.ElementParamValue.AVATAR_EDIT);
                }
            }
        });
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment
    public void Yj(int errCode, @NotNull MyBotInfo botInfo) {
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        if (errCode == 0) {
            com.tencent.robot.adelie.homepage.g.f366352a.a().postValue(new a24.i(ChangeMyBotOperationType.KEDIT, botInfo));
            Context context = getContext();
            if (context != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uid", this.uid);
                Unit unit = Unit.INSTANCE;
                com.tencent.kuikly.core.render.android.expand.module.l.e(context, "adelie_edit_robot", jSONObject);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotInfoUpdateService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRobotInfoUpdateService iRobotInfoUpdateService = (IRobotInfoUpdateService) iRuntimeService;
            if (iRobotInfoUpdateService != null) {
                iRobotInfoUpdateService.onFetchRobotAvatar(String.valueOf(botInfo.uin));
            }
            QRouteApi api = QRoute.api(IRobotProfileInfoApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IRobotProfileInfoApi::class.java)");
            IRobotProfileInfoApi.a.a((IRobotProfileInfoApi) api, String.valueOf(botInfo.uin), null, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment, com.tencent.robot.adelie.homepage.create.AdelieBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Jk();
        this.genStartTime = System.currentTimeMillis();
        QUIButton creationButton = getCreationButton();
        if (creationButton != null) {
            creationButton.setEnabled(false);
        }
        sk(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment
    public int getPageType() {
        return 2;
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return false;
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Runnable runnable = this.hideLoadingDialogRunnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
            this.hideLoadingDialogRunnable = null;
        }
        this.deleteLoadingDialog = null;
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        Activity activity;
        super.onFinish();
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f155078vu, R.anim.f155069vl);
        }
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment
    @NotNull
    public ChangeMyBotOperationType zj() {
        return ChangeMyBotOperationType.KEDIT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.adelie.homepage.create.AdelieCreationFragment
    public void zk() {
        super.zk();
        QUIButton creationButton = getCreationButton();
        if (creationButton != null) {
            creationButton.setEnabled(Lh().getHasChanged());
        }
    }
}

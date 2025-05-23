package com.tencent.mobileqq.minorsmode.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.minorsmode.MinorsKnowData;
import com.tencent.mobileqq.minorsmode.MinorsModeKnowType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.StudyModeBaseFragment;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.studymode.pwdverify.PwdVerifySuccess;
import com.tencent.mobileqq.studymode.r;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 L2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\"\u0010\u0015\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\"\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0014J\u001a\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010'\u001a\u00020\u0005H\u0014J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020$H\u0016J\u0012\u0010/\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J$\u00103\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040100j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000401`2H\u0016R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010@\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00106R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010F\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/minorsmode/fragment/MinorsModeKnowFragment;", "Lcom/tencent/mobileqq/studymode/StudyModeBaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/studymode/pwdverify/PwdVerifySuccess;", "", "Ih", "Lcom/tencent/mobileqq/minorsmode/a;", "minorsKnowData", "Hh", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "btn", "Uh", "Gh", "Rh", "Fh", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "targetType", "oldType", "Th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "rootLayout", "qh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "sh", "onPostThemeChanged", "", "onBackEvent", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mStudyModeTitle", UserInfo.SEX_FEMALE, "mStudyModeSubtitle", "G", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mStudyModeBtnTop", "H", "mStudyModeBtnBottom", "I", "mPolicyView", "Lcom/tencent/mobileqq/minorsmode/MinorsModeKnowType;", "J", "Lcom/tencent/mobileqq/minorsmode/MinorsModeKnowType;", "mMinorsKnowModeType", "K", "Z", "canGotoBrowser", "L", "isDeviceStudyModeOpen", "<init>", "()V", "M", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MinorsModeKnowFragment extends StudyModeBaseFragment implements View.OnClickListener, SimpleEventReceiver<PwdVerifySuccess> {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mStudyModeTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mStudyModeSubtitle;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIButton mStudyModeBtnTop;

    /* renamed from: H, reason: from kotlin metadata */
    private QUIButton mStudyModeBtnBottom;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mPolicyView;

    /* renamed from: J, reason: from kotlin metadata */
    private MinorsModeKnowType mMinorsKnowModeType = MinorsModeKnowType.INVALID;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean canGotoBrowser = true;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isDeviceStudyModeOpen;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f247148a;

        static {
            int[] iArr = new int[MinorsModeKnowType.values().length];
            try {
                iArr[MinorsModeKnowType.OPEN_BY_SYSTEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MinorsModeKnowType.OPEN_BY_SYSTEM_FROM_ELDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MinorsModeKnowType.CLOSE_BY_SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MinorsModeKnowType.CLOSE_BY_SYSTEM_TO_ELDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MinorsModeKnowType.CLOSE_ALONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MinorsModeKnowType.CLOSE_ALONE_TO_ELDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MinorsModeKnowType.CHECK_CLOSE_BY_SYSTEM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MinorsModeKnowType.ONLY_CHANGE_AGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f247148a = iArr;
        }
    }

    private final void Fh() {
        int e16 = r.e(getAppRuntime(), false);
        AppRuntime appRuntime = getAppRuntime();
        l lVar = (l) (appRuntime != null ? appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER) : null);
        if (lVar == null) {
            QLog.i("MinorsModeKnowFragment", 1, "manager is null, changeToElderMode failed!!! ");
        } else if (lVar.o()) {
            QLog.i("MinorsModeKnowFragment", 1, "manager is switching, changeToElderMode failed!!! ");
        } else {
            lVar.e(2, 3, e16, true);
        }
    }

    private final void Gh() {
        switch (b.f247148a[this.mMinorsKnowModeType.ordinal()]) {
            case 1:
            case 3:
            case 5:
            case 7:
                Rh();
                return;
            case 2:
                Th(getActivity(), 2, 3);
                return;
            case 4:
                Th(getActivity(), 3, 2);
                return;
            case 6:
                Fh();
                return;
            case 8:
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            default:
                QLog.i("MinorsModeKnowFragment", 1, "click on impl");
                return;
        }
    }

    private final void Hh(MinorsKnowData minorsKnowData) {
        TextView textView = this.mStudyModeTitle;
        QUIButton qUIButton = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStudyModeTitle");
            textView = null;
        }
        textView.setText(minorsKnowData.getTitle());
        TextView textView2 = this.mStudyModeSubtitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStudyModeSubtitle");
            textView2 = null;
        }
        textView2.setText(minorsKnowData.getDes());
        TextView textView3 = this.mPolicyView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPolicyView");
            textView3 = null;
        }
        textView3.setVisibility(minorsKnowData.getNeedTerm() ? 0 : 4);
        QUIButton qUIButton2 = this.mStudyModeBtnTop;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
            qUIButton2 = null;
        }
        qUIButton2.setText(minorsKnowData.getTopBtnTxt());
        QUIButton qUIButton3 = this.mStudyModeBtnBottom;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnBottom");
            qUIButton3 = null;
        }
        qUIButton3.setText(minorsKnowData.getBottomBtnTxt());
        QUIButton qUIButton4 = this.mStudyModeBtnBottom;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnBottom");
        } else {
            qUIButton = qUIButton4;
        }
        qUIButton.setVisibility(TextUtils.isEmpty(minorsKnowData.getBottomBtnTxt()) ? 8 : 0);
    }

    private final void Ih() {
        QUIButton qUIButton = null;
        switch (b.f247148a[this.mMinorsKnowModeType.ordinal()]) {
            case 1:
            case 2:
                MinorsKnowData b16 = MinorsKnowData.b(com.tencent.mobileqq.minorsmode.b.e(), null, null, false, null, null, 31, null);
                if (!TextUtils.isEmpty(com.tencent.common.config.pad.f.j(getContext()))) {
                    b16.h(b16.getDes() + "\n\n\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u77ed\u89c6\u9891\u5e74\u9f84\u8bbe\u7f6e\u5df2\u968f\u624b\u673a\u7cfb\u7edf\u66f4\u6539\u3002");
                }
                Hh(b16);
                QUIButton qUIButton2 = this.mStudyModeBtnTop;
                if (qUIButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                } else {
                    qUIButton = qUIButton2;
                }
                qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minorsmode.fragment.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MinorsModeKnowFragment.Jh(MinorsModeKnowFragment.this, view);
                    }
                });
                return;
            case 3:
                Hh(com.tencent.mobileqq.minorsmode.b.c());
                QUIButton qUIButton3 = this.mStudyModeBtnTop;
                if (qUIButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                } else {
                    qUIButton = qUIButton3;
                }
                qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minorsmode.fragment.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MinorsModeKnowFragment.Kh(MinorsModeKnowFragment.this, view);
                    }
                });
                return;
            case 4:
                Hh(com.tencent.mobileqq.minorsmode.b.c());
                QUIButton qUIButton4 = this.mStudyModeBtnTop;
                if (qUIButton4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                    qUIButton4 = null;
                }
                Uh(qUIButton4);
                QUIButton qUIButton5 = this.mStudyModeBtnTop;
                if (qUIButton5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                } else {
                    qUIButton = qUIButton5;
                }
                qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minorsmode.fragment.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MinorsModeKnowFragment.Lh(MinorsModeKnowFragment.this, view);
                    }
                });
                return;
            case 5:
                Hh(com.tencent.mobileqq.minorsmode.b.b());
                TextView textView = this.mStudyModeSubtitle;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeSubtitle");
                    textView = null;
                }
                textView.setGravity(49);
                QUIButton qUIButton6 = this.mStudyModeBtnTop;
                if (qUIButton6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                } else {
                    qUIButton = qUIButton6;
                }
                qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minorsmode.fragment.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MinorsModeKnowFragment.Mh(MinorsModeKnowFragment.this, view);
                    }
                });
                return;
            case 6:
                Hh(com.tencent.mobileqq.minorsmode.b.b());
                TextView textView2 = this.mStudyModeSubtitle;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeSubtitle");
                    textView2 = null;
                }
                textView2.setGravity(49);
                QUIButton qUIButton7 = this.mStudyModeBtnTop;
                if (qUIButton7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                    qUIButton7 = null;
                }
                Uh(qUIButton7);
                QUIButton qUIButton8 = this.mStudyModeBtnTop;
                if (qUIButton8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                } else {
                    qUIButton = qUIButton8;
                }
                qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minorsmode.fragment.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MinorsModeKnowFragment.Nh(MinorsModeKnowFragment.this, view);
                    }
                });
                return;
            case 7:
                Hh(com.tencent.mobileqq.minorsmode.b.a());
                QUIButton qUIButton9 = this.mStudyModeBtnTop;
                if (qUIButton9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                    qUIButton9 = null;
                }
                qUIButton9.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minorsmode.fragment.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MinorsModeKnowFragment.Oh(MinorsModeKnowFragment.this, view);
                    }
                });
                QUIButton qUIButton10 = this.mStudyModeBtnBottom;
                if (qUIButton10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnBottom");
                } else {
                    qUIButton = qUIButton10;
                }
                qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minorsmode.fragment.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MinorsModeKnowFragment.Ph(MinorsModeKnowFragment.this, view);
                    }
                });
                return;
            case 8:
                MinorsKnowData b17 = MinorsKnowData.b(com.tencent.mobileqq.minorsmode.b.d(), null, null, false, null, null, 31, null);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(b17.getTitle(), Arrays.copyOf(new Object[]{com.tencent.common.config.pad.f.j(getContext())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                b17.i(format);
                Hh(b17);
                QUIButton qUIButton11 = this.mStudyModeBtnTop;
                if (qUIButton11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStudyModeBtnTop");
                } else {
                    qUIButton = qUIButton11;
                }
                qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minorsmode.fragment.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MinorsModeKnowFragment.Qh(MinorsModeKnowFragment.this, view);
                    }
                });
                return;
            default:
                QLog.i("MinorsModeKnowFragment", 1, "initContentAndAction fail because type invalid");
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(MinorsModeKnowFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(MinorsModeKnowFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(MinorsModeKnowFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(MinorsModeKnowFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(MinorsModeKnowFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(MinorsModeKnowFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            JumpKidModeMgr.b().g(0, 2, (QQAppInterface) peekAppRuntime, this$0.getActivity(), 3, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(MinorsModeKnowFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(MinorsModeKnowFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    private final void Rh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            QLog.d("MinorsModeKnowFragment", 1, "goToMsgTab");
            FrameHelperActivity.gj(true, "MinorsModeKnowFragment");
            FrameHelperActivity.Zh();
            Intent aliasIntent = SplashActivity.getAliasIntent(activity);
            aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 1);
            aliasIntent.setFlags(335544320);
            activity.startActivity(aliasIntent);
            ((IChatsUtil) QRoute.api(IChatsUtil.class)).triggerChatsNtFilter(com.tencent.mobileqq.studymode.g.a());
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(MinorsModeKnowFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.canGotoBrowser = true;
    }

    private final void Uh(QUIButton btn) {
        btn.setText("\u70b9\u51fb\u56de\u5230\u5173\u6000\u6a21\u5f0f");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<PwdVerifySuccess>> getEventClass() {
        ArrayList<Class<PwdVerifySuccess>> arrayList = new ArrayList<>();
        arrayList.add(PwdVerifySuccess.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == -1) {
                QLog.i("MinorsModeKnowFragment", 1, "User changed study mode");
                Gh();
            } else {
                if (resultCode != 0) {
                    return;
                }
                QLog.i("MinorsModeKnowFragment", 1, "User canceled study mode change");
            }
        }
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        super.onBackEvent();
        Gh();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f181225) {
            if (!this.canGotoBrowser) {
                QLog.d("MinorsModeKnowFragment", 1, "can not go to browser, wait!!! ");
                return;
            }
            this.canGotoBrowser = false;
            TextView textView = this.mPolicyView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPolicyView");
                textView = null;
            }
            textView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.minorsmode.fragment.i
                @Override // java.lang.Runnable
                public final void run() {
                    MinorsModeKnowFragment.Sh(MinorsModeKnowFragment.this);
                }
            }, 1000L);
            try {
                if (getActivity() != null) {
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(getQBaseActivity(), RouterConstants.UI_ROUTE_BROWSER);
                    activityURIRequest.extra().putString("url", "https://rule.tencent.com/rule/preview/9b3a1d99-425a-469c-88eb-3ad4406180a3");
                    QRoute.startUri(activityURIRequest, (o) null);
                }
            } catch (Exception e16) {
                QLog.d("MinorsModeKnowFragment", 1, "open TERMS_OF_TEENAGER_FEATURES url exception: ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        Bundle extras;
        super.onCreate(savedInstanceState);
        Context context = getContext();
        if (context != null) {
            boolean k3 = com.tencent.common.config.pad.f.k(context);
            this.isDeviceStudyModeOpen = k3;
            QLog.i("MinorsModeKnowFragment", 1, "isDeviceStudyModeOpen" + k3);
        }
        FragmentActivity activity = getActivity();
        Serializable serializable = (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) ? null : extras.getSerializable("KEY_MINORS_MODE_TYPE");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.minorsmode.MinorsModeKnowType");
        this.mMinorsKnowModeType = (MinorsModeKnowType) serializable;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        sh();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        FragmentActivity activity;
        if (event instanceof PwdVerifySuccess) {
            boolean h16 = JumpKidModeMgr.b().h();
            int d16 = JumpKidModeMgr.b().d();
            int c16 = JumpKidModeMgr.b().c();
            QLog.i("MinorsModeKnowFragment", 1, "onReceiveEvent, pwd verify suc, targetMode=" + d16 + ",oldMode=" + c16 + ",isJumpToStudyPwdVerify=" + h16);
            if (d16 == -1 || c16 == -1 || (activity = getActivity()) == null) {
                return;
            }
            AppRuntime appRuntime = getAppRuntime();
            Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
            com.tencent.mobileqq.minorsmode.c.b(c16, d16, appRuntime, "MinorsModeKnowFragment", activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.f180821);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.study_mode_title)");
        this.mStudyModeTitle = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f180720);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.study_mode_subtitle)");
        this.mStudyModeSubtitle = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f181225);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById3;
        this.mPolicyView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPolicyView");
            textView = null;
        }
        textView.setOnClickListener(this);
        View findViewById4 = view.findViewById(R.id.f181023);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.study_open_btn_top)");
        this.mStudyModeBtnTop = (QUIButton) findViewById4;
        View findViewById5 = view.findViewById(R.id.f180922);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.study_open_btn_bottom)");
        this.mStudyModeBtnBottom = (QUIButton) findViewById5;
        sh();
        Ih();
    }

    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    protected void qh(LayoutInflater inflater, ViewGroup rootLayout) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        inflater.inflate(R.layout.f127300a, rootLayout, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.studymode.StudyModeBaseFragment
    public void sh() {
        this.C.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
    }

    private final void Th(Activity activity, int targetType, int oldType) {
        if (activity == null || ElderModeManager.m(true, targetType, oldType, activity).booleanValue()) {
            return;
        }
        Rh();
    }
}

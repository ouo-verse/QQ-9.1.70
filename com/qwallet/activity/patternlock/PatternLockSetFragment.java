package com.qwallet.activity.patternlock;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.qwallet.activity.QWalletTitleBarActivity;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tenpay.api.TenpayInterface;
import com.tenpay.pay.PayChannelUtils;
import com.tenpay.realname.RealNameSource;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0006\u0010\u0019\u001a\u00020\u0005J\"\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0017J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/qwallet/activity/patternlock/PatternLockSetFragment;", "Lcom/qwallet/activity/QWalletTitleBarActivity;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initUI", "Ch", "", "pwdType", "", "Ih", "Fh", "Kh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onDestroyView", "Jh", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/widget/QFormSimpleItem;", "V", "Lcom/tencent/mobileqq/widget/QFormSimpleItem;", "reviseItem", "Landroid/widget/CheckBox;", "W", "Landroid/widget/CheckBox;", "ivSelected", "X", "ivClosed", "Landroid/widget/RelativeLayout;", "Y", "Landroid/widget/RelativeLayout;", "unlockGesture", "Z", "closeGesture", "Lcom/qwallet/activity/patternlock/biz/a;", "a0", "Lcom/qwallet/activity/patternlock/biz/a;", "patternLockBiz", "<init>", "()V", "b0", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class PatternLockSetFragment extends QWalletTitleBarActivity implements View.OnClickListener {

    /* renamed from: V, reason: from kotlin metadata */
    private QFormSimpleItem reviseItem;

    /* renamed from: W, reason: from kotlin metadata */
    private CheckBox ivSelected;

    /* renamed from: X, reason: from kotlin metadata */
    private CheckBox ivClosed;

    /* renamed from: Y, reason: from kotlin metadata */
    private RelativeLayout unlockGesture;

    /* renamed from: Z, reason: from kotlin metadata */
    private RelativeLayout closeGesture;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private com.qwallet.activity.patternlock.biz.a patternLockBiz;

    private final void Ch() {
        int pWDType;
        FragmentActivity activity = getActivity();
        if (activity != null && (pWDType = PatternLockUtils.getPWDType(activity, QWalletUtils.h())) != 0 && pWDType != 3) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = activity.getString(R.string.f179743_7);
            Intrinsics.checkNotNullExpressionValue(string, "curActivity.getString(co\u2026_gesture_pay_switch_hint)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Ih(pWDType)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            PatternLockHelper.d(activity, 230, null, format, activity.getString(R.string.cancel), activity.getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.qwallet.activity.patternlock.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PatternLockSetFragment.Dh(PatternLockSetFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.qwallet.activity.patternlock.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PatternLockSetFragment.Eh(dialogInterface, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(PatternLockSetFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qwallet.activity.patternlock.biz.a aVar = this$0.patternLockBiz;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("patternLockBiz");
            aVar = null;
        }
        aVar.i(1);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void Fh() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            PatternLockHelper.d(activity, 230, null, activity.getString(R.string.f179683_1), activity.getString(R.string.cancel), activity.getString(R.string.f179803_c), new DialogInterface.OnClickListener() { // from class: com.qwallet.activity.patternlock.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PatternLockSetFragment.Gh(PatternLockSetFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.qwallet.activity.patternlock.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PatternLockSetFragment.Hh(dialogInterface, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(PatternLockSetFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qwallet.activity.patternlock.biz.a aVar = this$0.patternLockBiz;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("patternLockBiz");
            aVar = null;
        }
        aVar.i(2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final String Ih(int pwdType) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return "";
        }
        if (pwdType != 0) {
            if (pwdType != 2) {
                return "";
            }
            String string = activity.getString(R.string.f179723_5);
            Intrinsics.checkNotNullExpressionValue(string, "curActivity.getString(co\u2026sture_pay_pwd_title_face)");
            return string;
        }
        String string2 = activity.getString(R.string.f179733_6);
        Intrinsics.checkNotNullExpressionValue(string2, "curActivity.getString(co\u2026ure_pay_pwd_title_finger)");
        return string2;
    }

    private final void Kh() {
        final FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            final Bundle bundle = new Bundle();
            bundle.putString("userId", com.tencent.mobileqq.base.a.c());
            bundle.putString("sourceId", "7");
            bundle.putString(RealNameSource.EXTRA_KEY_SOURCE_NAME, RealNameSource.INSTANCE.getSourceName("7"));
            PatternLockHelper.d(activity, 230, null, activity.getString(R.string.f179763_9), activity.getString(R.string.cancel), activity.getString(R.string.f179813_d), new DialogInterface.OnClickListener() { // from class: com.qwallet.activity.patternlock.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PatternLockSetFragment.Lh(FragmentActivity.this, bundle, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.qwallet.activity.patternlock.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PatternLockSetFragment.Mh(dialogInterface, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(FragmentActivity fragmentActivity, Bundle data, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(data, "$data");
        TenpayInterface.gotoView(fragmentActivity, "idCardVerify", com.tencent.mobileqq.base.a.c(), com.tencent.mobileqq.base.a.b(), data, new ResultReceiver() { // from class: com.qwallet.activity.patternlock.PatternLockSetFragment$verifyIDCard$1$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                QLog.i("PatternLockSetFragment", 2, "resultCode: " + resultCode);
            }
        });
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void initUI(View rootView) {
        boolean z16;
        setTitle(R.string.g_8);
        boolean isPatternLockOpened = PatternLockUtils.isPatternLockOpened(getContext(), QWalletUtils.h());
        int pWDType = PatternLockUtils.getPWDType(getContext(), QWalletUtils.h());
        int i3 = 0;
        if (isPatternLockOpened && pWDType == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        View findViewById = rootView.findViewById(R.id.y8w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_selected)");
        CheckBox checkBox = (CheckBox) findViewById;
        this.ivSelected = checkBox;
        RelativeLayout relativeLayout = null;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivSelected");
            checkBox = null;
        }
        checkBox.setChecked(z16);
        View findViewById2 = rootView.findViewById(R.id.y1o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_closed)");
        CheckBox checkBox2 = (CheckBox) findViewById2;
        this.ivClosed = checkBox2;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClosed");
            checkBox2 = null;
        }
        checkBox2.setChecked(!isPatternLockOpened);
        View findViewById3 = rootView.findViewById(R.id.h56);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026y_patternlock_set_revise)");
        QFormSimpleItem qFormSimpleItem = (QFormSimpleItem) findViewById3;
        this.reviseItem = qFormSimpleItem;
        if (qFormSimpleItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviseItem");
            qFormSimpleItem = null;
        }
        if (!z16) {
            i3 = 8;
        }
        qFormSimpleItem.setVisibility(i3);
        QFormSimpleItem qFormSimpleItem2 = this.reviseItem;
        if (qFormSimpleItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviseItem");
            qFormSimpleItem2 = null;
        }
        qFormSimpleItem2.setOnClickListener(this);
        QFormSimpleItem qFormSimpleItem3 = this.reviseItem;
        if (qFormSimpleItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviseItem");
            qFormSimpleItem3 = null;
        }
        PayChannelUtils.updateBgRound(qFormSimpleItem3, PayChannelUtils.BgRadiusEnum.BothRound, x.c(getContext(), 8.0f));
        View findViewById4 = rootView.findViewById(R.id.f114206sp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.unlock_gesture)");
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById4;
        this.unlockGesture = relativeLayout2;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unlockGesture");
            relativeLayout2 = null;
        }
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = this.unlockGesture;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unlockGesture");
            relativeLayout3 = null;
        }
        PayChannelUtils.updateBgRound(relativeLayout3, PayChannelUtils.BgRadiusEnum.TopRound, x.c(getContext(), 8.0f));
        View findViewById5 = rootView.findViewById(R.id.tzj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.close_gesture)");
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById5;
        this.closeGesture = relativeLayout4;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeGesture");
            relativeLayout4 = null;
        }
        relativeLayout4.setOnClickListener(this);
        RelativeLayout relativeLayout5 = this.closeGesture;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeGesture");
        } else {
            relativeLayout = relativeLayout5;
        }
        PayChannelUtils.updateBgRound(relativeLayout, PayChannelUtils.BgRadiusEnum.BottomRound, x.c(getContext(), 8.0f));
    }

    public final void Jh() {
        int i3;
        boolean isPatternLockOpened = PatternLockUtils.isPatternLockOpened(getContext(), QWalletUtils.h());
        CheckBox checkBox = this.ivSelected;
        QFormSimpleItem qFormSimpleItem = null;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivSelected");
            checkBox = null;
        }
        checkBox.setChecked(isPatternLockOpened);
        CheckBox checkBox2 = this.ivClosed;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClosed");
            checkBox2 = null;
        }
        checkBox2.setChecked(!isPatternLockOpened);
        QFormSimpleItem qFormSimpleItem2 = this.reviseItem;
        if (qFormSimpleItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviseItem");
        } else {
            qFormSimpleItem = qFormSimpleItem2;
        }
        if (isPatternLockOpened) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qFormSimpleItem.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != 312) {
            if (requestCode != 313) {
                if (requestCode != 601) {
                    return;
                }
            } else {
                if (PatternLockUtils.isPatternLockOpened(getContext(), QWalletUtils.h())) {
                    Jh();
                    PatternLockUtils.setNewCreatePatternLock(getContext(), QWalletUtils.h(), true);
                    return;
                }
                return;
            }
        }
        if (resultCode == -1) {
            PatternLockUtils.setNewCreatePatternLock(getContext(), QWalletUtils.h(), true);
            Jh();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            boolean isPatternLockOpened = PatternLockUtils.isPatternLockOpened(getContext(), QWalletUtils.h());
            int id5 = v3.getId();
            if (id5 == R.id.f114206sp) {
                if (isPatternLockOpened) {
                    QLog.i("PatternLockSetFragment", 2, "isPatternLockOpened");
                } else {
                    com.qwallet.activity.patternlock.biz.a aVar = this.patternLockBiz;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("patternLockBiz");
                        aVar = null;
                    }
                    aVar.i(1);
                }
            } else if (id5 == R.id.tzj) {
                if (isPatternLockOpened) {
                    if (com.tencent.mobileqq.qwallet.utils.g.c("qwallet_is_pws_enter_" + com.tencent.mobileqq.base.a.c(), true)) {
                        Fh();
                    } else {
                        Kh();
                    }
                }
            } else if (id5 == R.id.h56) {
                Intent intent = new Intent();
                intent.putExtra("action_mode", 3);
                intent.putExtra("enable_act_anim", true);
                intent.putExtra(IPCConst.KEY_TITLE_TEXT, getString(R.string.bi9));
                launchFragmentForResult(intent, PatternLockActivity.class, 312);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hh9, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.qwallet.activity.patternlock.biz.a aVar = this.patternLockBiz;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("patternLockBiz");
            aVar = null;
        }
        aVar.a();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(getActivity(), true, true);
    }

    @Override // com.qwallet.activity.QWalletTitleBarActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        com.qwallet.activity.patternlock.biz.a b16 = com.qwallet.activity.patternlock.biz.c.a().b(0);
        Intrinsics.checkNotNullExpressionValue(b16, "getInstance().getLockScr\u2026er.PASSWORD_TYPE_GESTURE)");
        this.patternLockBiz = b16;
        if (b16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("patternLockBiz");
            b16 = null;
        }
        b16.e(new WeakReference<>(getActivity()));
        Ch();
    }
}

package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u001e\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0017R\u0018\u0010!\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeSignaturePartV3;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "", "isNull", "", "S9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N9", "M9", "L9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/n;", "bean", "R9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/l;", "T9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "onTouch", "f", "Landroid/view/View;", "signatureContainer", tl.h.F, "Z", "isShowZPlanDrawer", "<init>", "()V", "i", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQSettingMeSignaturePartV3 extends com.tencent.mobileqq.part.a implements View.OnClickListener, View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View signatureContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isShowZPlanDrawer;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeSignaturePartV3$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeSignaturePartV3$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeSignaturePartV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void J9() {
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeSignaturePartV3$bindContainer$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSignaturePartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    QQSettingMeSignaturePartV3.this.isShowZPlanDrawer = true;
                } else if (num != null && num.intValue() == 0) {
                    QQSettingMeSignaturePartV3.this.isShowZPlanDrawer = false;
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.bm
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeSignaturePartV3.K9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void L9() {
        VideoReport.reportEvent("imp", this.signatureContainer, null);
    }

    private final void M9() {
        VideoReport.setElementId(this.signatureContainer, "em_bas_personal_signature");
        VideoReport.setElementClickPolicy(this.signatureContainer, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.signatureContainer, ExposurePolicy.REPORT_NONE);
    }

    private final void N9(View rootView) {
        View view;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f165035uo3);
        } else {
            view = null;
        }
        this.signatureContainer = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QQSettingMeSignaturePartV3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(com.tencent.mobileqq.activity.qqsettingme.bean.n bean) {
        TextView textView;
        ImageView imageView;
        View view;
        View view2 = this.signatureContainer;
        if (view2 == null) {
            return;
        }
        ImageView imageView2 = null;
        if (view2 != null) {
            textView = (TextView) view2.findViewById(R.id.f165034uo2);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setTextColor(ex.b(R.color.qui_common_text_secondary));
        }
        View view3 = this.signatureContainer;
        if (view3 != null) {
            imageView = (ImageView) view3.findViewById(R.id.unp);
        } else {
            imageView = null;
        }
        StringBuilder sb5 = new StringBuilder(100);
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeSignaturePartV3", 2, "preLoadSignature, actionText = " + bean.f184929b + ", actionId = " + bean.f184928a + ", dataText = " + bean.f184930c + ", plainText = " + bean.f184932e);
        }
        View view4 = this.signatureContainer;
        if (view4 != null) {
            imageView2 = (ImageView) view4.findViewById(R.id.f165033uo1);
        }
        if (!TextUtils.isEmpty(bean.f184929b)) {
            if (imageView2 != null) {
                imageView2.setImageBitmap(bean.f184934g);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            sb5.append(bean.f184929b);
            if (!TextUtils.isEmpty(bean.f184930c)) {
                sb5.append(bean.f184930c);
            }
            sb5.append(TokenParser.SP);
        } else {
            if (imageView2 != null) {
                imageView2.setBackgroundResource(0);
            }
            if (imageView2 != null) {
                imageView2.setPadding(0, 0, 0, 0);
            }
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.qui_edit_icon_secondary);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(bean.f184933f)) {
            if (!TextUtils.isEmpty(bean.f184931d)) {
                sb5.append(bean.f184931d);
            }
            if (!TextUtils.isEmpty(bean.f184932e)) {
                sb5.append(bean.f184932e);
            }
        } else {
            sb5.append(bean.f184933f);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        if (TextUtils.isEmpty(sb6)) {
            if (textView != null) {
                textView.setText(R.string.fru);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            S9(false);
        } else {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            S9(true);
            if (com.tencent.mobileqq.utils.ah.m0()) {
                if (textView != null) {
                    textView.setText(new QQText(sb6 + TokenParser.SP, 1, 16));
                }
            } else if (textView != null) {
                textView.setText(new QQText(sb6, 1, 16));
            }
        }
        if (AppSetting.f99565y && (view = this.signatureContainer) != null) {
            view.setContentDescription("\u4e2a\u6027\u7b7e\u540d" + sb6);
        }
    }

    private final void S9(boolean isNull) {
        View view;
        View view2;
        View view3;
        List<View> listOf;
        View[] viewArr = new View[3];
        View view4 = this.signatureContainer;
        if (view4 != null) {
            view = view4.findViewById(R.id.f165034uo2);
        } else {
            view = null;
        }
        viewArr[0] = view;
        View view5 = this.signatureContainer;
        if (view5 != null) {
            view2 = view5.findViewById(R.id.f165033uo1);
        } else {
            view2 = null;
        }
        viewArr[1] = view2;
        View view6 = this.signatureContainer;
        if (view6 != null) {
            view3 = view6.findViewById(R.id.unp);
        } else {
            view3 = null;
        }
        viewArr[2] = view3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        for (View view7 : listOf) {
            if (isNull) {
                if (view7 != null) {
                    view7.setClickable(false);
                }
                if (view7 != null) {
                    view7.setOnTouchListener(null);
                }
            } else {
                if (view7 != null) {
                    view7.setClickable(true);
                }
                if (view7 != null) {
                    view7.setOnTouchListener(this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(com.tencent.mobileqq.activity.qqsettingme.bean.l bean) {
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        QQText qQText;
        View view;
        String str;
        String str2;
        View view2 = this.signatureContainer;
        CharSequence charSequence = null;
        if (view2 != null) {
            imageView = (ImageView) view2.findViewById(R.id.f165033uo1);
        } else {
            imageView = null;
        }
        View view3 = this.signatureContainer;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.f165034uo2);
        } else {
            textView = null;
        }
        View view4 = this.signatureContainer;
        if (view4 != null) {
            imageView2 = (ImageView) view4.findViewById(R.id.unp);
        } else {
            imageView2 = null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SharedPreferences.Editor edit = peekAppRuntime.getApp().getSharedPreferences("qqsettingme_signature" + peekAppRuntime.getAccount(), 0).edit();
        Intrinsics.checkNotNullExpressionValue(edit, "app.app\n            .get\u2026VATE)\n            .edit()");
        StringBuilder sb5 = new StringBuilder(100);
        RichStatus richStatus = bean.f184922a;
        if (richStatus != null && !TextUtils.isEmpty(richStatus.actionText)) {
            if (imageView != null) {
                imageView.setImageBitmap(bean.f184923b);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            sb5.append(bean.f184922a.actionText);
            if (!TextUtils.isEmpty(bean.f184922a.dataText)) {
                sb5.append(bean.f184922a.dataText);
            }
            sb5.append(TokenParser.SP);
            edit.putInt("actionId", bean.f184922a.actionId);
            edit.putString("actionText", bean.f184922a.actionText);
            edit.putString("dataText", bean.f184922a.dataText);
        } else {
            if (imageView != null) {
                imageView.setBackgroundResource(0);
            }
            if (imageView != null) {
                imageView.setPadding(0, 0, 0, 0);
            }
            if (imageView != null) {
                imageView.setImageResource(R.drawable.qui_edit_icon_secondary);
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        RichStatus richStatus2 = bean.f184922a;
        if (richStatus2 != null) {
            if (richStatus2.hasTopic()) {
                if (bean.f184922a.shouldShowAtHead()) {
                    String str3 = bean.f184922a.topicToPlainText();
                    sb5.append(str3);
                    edit.putString(MessageForRichState.SIGN_MSG_TOPICS, str3);
                    ArrayList<String> arrayList = bean.f184922a.plainText;
                    if (arrayList != null && arrayList.size() > 0) {
                        str2 = bean.f184922a.plainText.get(0);
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        sb5.append(str2);
                    }
                    edit.putString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, str2);
                }
                if (bean.f184922a.shouldShowMixing()) {
                    String plainText = bean.f184922a.getPlainText();
                    sb5.append(plainText);
                    edit.putString("plainMixTopic", plainText);
                }
            } else {
                ArrayList<String> arrayList2 = bean.f184922a.plainText;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    str = bean.f184922a.plainText.get(0);
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                }
                edit.putString(IMiniCardBeancurd.SIGN_PLAIN_TEXT, str);
            }
        }
        edit.apply();
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        if (TextUtils.isEmpty(sb6)) {
            if (textView != null) {
                textView.setText(R.string.fru);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            S9(false);
        } else {
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            S9(true);
            if (com.tencent.mobileqq.utils.ah.m0()) {
                qQText = new QQText(sb6 + TokenParser.SP, 1, 16);
            } else {
                qQText = new QQText(sb6, 1, 16);
            }
            if (textView != null) {
                charSequence = textView.getText();
            }
            if (!TextUtils.equals(charSequence, qQText) && textView != null) {
                textView.setText(qQText);
            }
        }
        if (AppSetting.f99565y && (view = this.signatureContainer) != null) {
            view.setContentDescription("\u4e2a\u6027\u7b7e\u540d" + sb6);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        TextView textView;
        CharSequence charSequence;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else if (!this.isShowZPlanDrawer && !FastClickUtils.isFastDoubleClick("QQSettingMeSignaturePartV3")) {
            if (this.signatureContainer != null && getActivity() != null) {
                View view = this.signatureContainer;
                if (view != null) {
                    textView = (TextView) view.findViewById(R.id.f165034uo2);
                } else {
                    textView = null;
                }
                if (v3 != null) {
                    if (textView != null) {
                        charSequence = textView.getText();
                    } else {
                        charSequence = null;
                    }
                    if (charSequence != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    v3.setTag(Boolean.valueOf(z16));
                }
            }
            VideoReport.reportEvent("clck", this.signatureContainer, null);
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_signature").onClick(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        List<View> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        N9(rootView);
        M9();
        View[] viewArr = new View[3];
        View view3 = this.signatureContainer;
        View view4 = null;
        if (view3 != null) {
            view = view3.findViewById(R.id.f165034uo2);
        } else {
            view = null;
        }
        viewArr[0] = view;
        View view5 = this.signatureContainer;
        if (view5 != null) {
            view2 = view5.findViewById(R.id.f165033uo1);
        } else {
            view2 = null;
        }
        viewArr[1] = view2;
        View view6 = this.signatureContainer;
        if (view6 != null) {
            view4 = view6.findViewById(R.id.unp);
        }
        viewArr[2] = view4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        for (View view7 : listOf) {
            if (view7 != null) {
                view7.setOnClickListener(this);
            }
            if (view7 != null) {
                view7.setOnTouchListener(this);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        J9();
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.n> mutableLiveData = qQSettingMeViewModel.E;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.n, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.n, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeSignaturePartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeSignaturePartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.n nVar) {
                invoke2(nVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.n it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeSignaturePartV3 qQSettingMeSignaturePartV3 = QQSettingMeSignaturePartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeSignaturePartV3.R9(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.bk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeSignaturePartV3.O9(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.l> mutableLiveData2 = qQSettingMeViewModel.F;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.l, Unit> function12 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.l, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeSignaturePartV3$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeSignaturePartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.l lVar) {
                invoke2(lVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.l it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeSignaturePartV3 qQSettingMeSignaturePartV3 = QQSettingMeSignaturePartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeSignaturePartV3.T9(it);
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.parts.bl
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeSignaturePartV3.P9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.post(new Runnable() { // from class: com.tencent.mobileqq.parts.bj
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeSignaturePartV3.Q9(QQSettingMeSignaturePartV3.this);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        if (v3 != null && !this.isShowZPlanDrawer && (view = this.signatureContainer) != null) {
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).c2(view, event);
        }
        return false;
    }
}

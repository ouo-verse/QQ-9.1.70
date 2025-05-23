package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSPrivateSettingBean;
import com.tencent.biz.qqcircle.beans.QFSPrivateSubSettingBean;
import com.tencent.biz.qqcircle.events.QFSPrivacySubSettingUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSRecSwitchChangeEvent;
import com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleProfile$SetUserSwitchRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0016\u0010\u001c\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0012\u0010!\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0012\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/da;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "ba", "S9", "ha", "", "Lcom/tencent/biz/qqcircle/beans/QFSPrivateSettingBean;", "dataList", "V9", "Q9", "X9", "T9", "M9", "", "enable", "ca", "", "eid", "J9", "", "type", "code", "isChecked", "ea", "Z9", "L9", "Lqqcircle/QQCircleFeedBase$StMainPageBasicBusiRspData;", "K9", "I9", "onInitView", "getLogTag", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/beans/QFSPrivateSubSettingBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QFSPrivateSubSettingBean;", "subSettingBean", "Lcom/tencent/biz/qqcircle/adapter/ak;", "e", "Lcom/tencent/biz/qqcircle/adapter/ak;", "adapter", "<init>", "()V", "f", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class da extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPrivateSubSettingBean subSettingBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.adapter.ak adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/bizparts/da$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            com.tencent.biz.qqcircle.launcher.c.g(da.this.getContext(), uq3.c.N2());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setColor(QFSQUIUtilsKt.d(da.this.getContext(), R.color.qui_common_text_link));
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/bizparts/da$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    private final void I9() {
        Activity activity;
        if (!getPartManager().onBackEvent() && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    private final void J9(String eid) {
        Map<String, Object> dtElementParams = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(dtElementParams, "dtElementParams");
        dtElementParams.put("xsj_eid", eid);
        dtElementParams.put("xsj_custom_pgid", Integer.valueOf(getPageId()));
        VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_PANEL_ACTION, dtElementParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final QQCircleFeedBase$StMainPageBasicBusiRspData K9() {
        String q16 = com.tencent.biz.qqcircle.immersive.utils.r.q();
        MutableLiveData globalData = w20.a.j().getGlobalData(QQCircleFeedBase$StMainPageBasicBusiRspData.class, q16);
        if (globalData != null && globalData.getValue() != 0) {
            return (QQCircleFeedBase$StMainPageBasicBusiRspData) globalData.getValue();
        }
        MutableLiveData globalData2 = w20.a.j().getGlobalData(com.tencent.biz.qqcircle.immersive.personal.data.w.class, q16);
        if (globalData2 != null && globalData2.getValue() != 0) {
            T value = globalData2.getValue();
            Intrinsics.checkNotNull(value);
            return ((com.tencent.biz.qqcircle.immersive.personal.data.w) value).e();
        }
        return null;
    }

    private final String L9() {
        QQCircleFeedBase$StMainPageBasicBusiRspData K9 = K9();
        if (K9 == null) {
            return "";
        }
        String a16 = com.tencent.biz.qqcircle.immersive.utils.af.a(K9.urlInfo.get(), "personalizedTagUrl");
        Intrinsics.checkNotNullExpressionValue(a16, "getUrl(busiRspData.urlIn\u2026NFO_PERSONALIZED_TAG_URL)");
        return a16;
    }

    private final void M9(List<QFSPrivateSettingBean> dataList) {
        if (!Intrinsics.areEqual("1", uq3.c.b1("qqcircle", "qqcircle_personal_recommend_switch_enable", "1"))) {
            return;
        }
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ENABLE_PERSONAL_RECOMMEND);
        qFSPrivateSettingBean.setTitle(uq3.c.b1("qqcircle", "qqcircle_personal_recommend_switch_header", getContext().getString(R.string.f183083i8)));
        String str = uq3.c.b1("qqcircle", "qqcircle_personal_recommend_switch_hint", com.dataline.util.j.d(getContext().getString(R.string.f183073i7))) + "\uff0c" + getContext().getString(R.string.f183093i9);
        String string = getContext().getString(R.string.f183103i_);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026m_setting_explain_second)");
        SpannableString spannableString = new SpannableString(str + string);
        spannableString.setSpan(new b(), str.length(), str.length() + string.length(), 33);
        qFSPrivateSettingBean.setHide(spannableString);
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cs
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                da.N9(da.this, compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_PRIVACY_SWITCH_INDIVIDUATION_RECOM);
        dataList.add(qFSPrivateSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(final da this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!compoundButton.isPressed()) {
            return;
        }
        if (!z16) {
            this$0.J9(QCircleDaTongConstant.ElementId.EM_XSJ_PERSONALIZE_SETTING_PANEL);
            QCircleCustomDialog.O(this$0.getContext()).c0(com.tencent.biz.qqcircle.utils.h.a(R.string.f184223la)).g0(com.tencent.biz.qqcircle.utils.h.a(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.cx
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    da.O9(da.this, dialogInterface, i3);
                }
            }).e0(com.tencent.biz.qqcircle.utils.h.a(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.cy
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    da.P9(da.this, dialogInterface, i3);
                }
            }).show();
            this$0.J9("panel_exp");
            return;
        }
        this$0.ca(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(da this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ca(false);
        this$0.J9(QCircleDaTongConstant.ElementId.EM_XSJ_PERSONALIZE_SETTING_PANEL_CONTINUE_BUTTON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(da this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.adapter.ak akVar = this$0.adapter;
        if (akVar != null) {
            int size = akVar.i0().size();
            for (int i16 = 0; i16 < size; i16++) {
                QFSPrivateSettingBean qFSPrivateSettingBean = akVar.i0().get(i16);
                Intrinsics.checkNotNullExpressionValue(qFSPrivateSettingBean, "it.dataList[i]");
                QFSPrivateSettingBean qFSPrivateSettingBean2 = qFSPrivateSettingBean;
                if (TextUtils.equals(qFSPrivateSettingBean2.getKey(), QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ENABLE_PERSONAL_RECOMMEND)) {
                    qFSPrivateSettingBean2.setChecked(true);
                    akVar.notifyItemChanged(i16);
                }
            }
            this$0.J9(QCircleDaTongConstant.ElementId.EM_XSJ_PERSONALIZE_SETTING_PANEL_CANCEL_BUTTON);
        }
    }

    private final void Q9(List<QFSPrivateSettingBean> dataList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_RECOM_LIKE_FEED_TO_FRIENDS);
        qFSPrivateSettingBean.setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f1913744m));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f1913844n));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.ct
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                da.R9(da.this, compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_LIKE_FEED_RECOM_FRIEND_BTN);
        dataList.add(qFSPrivateSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(da this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea(14, 27, z16);
    }

    private final void S9(View rootView) {
        RecyclerView recyclerView;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f515828h);
        } else {
            recyclerView = null;
        }
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        }
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new c());
        }
        com.tencent.biz.qqcircle.adapter.ak akVar = new com.tencent.biz.qqcircle.adapter.ak();
        this.adapter = akVar;
        if (recyclerView != null) {
            recyclerView.setAdapter(akVar);
        }
    }

    private final void T9(List<QFSPrivateSettingBean> dataList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_CONTRACT_SWITCH);
        qFSPrivateSettingBean.setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f184923n7));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f184933n8));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cr
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                da.U9(da.this, compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_ADDRESS_BOOK_BUTTON);
        dataList.add(qFSPrivateSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(da this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea(16, 29, z16);
        if (z16) {
            com.tencent.biz.qqcircle.helpers.k kVar = com.tencent.biz.qqcircle.helpers.k.f84627a;
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            com.tencent.biz.qqcircle.helpers.k.k(kVar, activity, false, null, 4, null);
        }
    }

    private final void V9(List<QFSPrivateSettingBean> dataList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRAISED);
        qFSPrivateSettingBean.setTitle(uq3.c.b1("qqcircle", "qqcircle_show_praised_profile_switch_header", getContext().getString(R.string.f185023ng)));
        qFSPrivateSettingBean.setHide(uq3.c.b1("qqcircle", "qqcircle_show_praised_profile_switch_hint", getContext().getString(R.string.f185033nh)));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cw
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                da.W9(da.this, compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_FAVOR_LIST_BUTTON);
        dataList.add(qFSPrivateSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(da this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea(3, 6, z16);
    }

    private final void X9(List<QFSPrivateSettingBean> dataList) {
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRESENTATION_OFM);
        qFSPrivateSettingBean.setTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.f195834fo));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f195844fp));
        qFSPrivateSettingBean.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.cv
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                da.Y9(da.this, compoundButton, z16);
            }
        });
        qFSPrivateSettingBean.setEid(QCircleDaTongConstant.ElementId.EM_XSJ_PRIVACY_SWITCH_RECOM_ME);
        dataList.add(qFSPrivateSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(da this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea(17, 33, z16);
    }

    private final void Z9(List<QFSPrivateSettingBean> dataList) {
        final String L9 = L9();
        if (TextUtils.isEmpty(L9)) {
            return;
        }
        QFSPrivateSettingBean qFSPrivateSettingBean = new QFSPrivateSettingBean(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_TEENAGE_MANAGER);
        qFSPrivateSettingBean.setLeftText(com.tencent.biz.qqcircle.utils.h.a(R.string.f181933f4));
        qFSPrivateSettingBean.setHide(com.tencent.biz.qqcircle.utils.h.a(R.string.f196074gb));
        qFSPrivateSettingBean.setViewType(2);
        qFSPrivateSettingBean.setBgType(0);
        qFSPrivateSettingBean.setIsNeedGap(true);
        qFSPrivateSettingBean.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.cu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                da.aa(da.this, L9, view);
            }
        });
        dataList.add(qFSPrivateSettingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(da this$0, String tagManagerUrl, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tagManagerUrl, "$tagManagerUrl");
        com.tencent.biz.qqcircle.launcher.c.g(this$0.getContext(), tagManagerUrl);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ba(View rootView) {
        ImageView imageView;
        QCircleBaseFragment qCircleBaseFragment;
        TextView textView = null;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.y_2);
        } else {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof QCircleBaseFragment) {
            qCircleBaseFragment = (QCircleBaseFragment) partHost;
        } else {
            qCircleBaseFragment = null;
        }
        if (qCircleBaseFragment != null) {
            qCircleBaseFragment.setExcludeInteractiveView(imageView);
        }
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f55572i_);
        }
        QFSPrivateSubSettingBean qFSPrivateSubSettingBean = this.subSettingBean;
        if (qFSPrivateSubSettingBean != null && textView != null) {
            textView.setText(qFSPrivateSubSettingBean.getTitle());
        }
    }

    private final void ca(final boolean enable) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(5, !enable ? 1 : 0), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.cq
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                da.da(enable, baseRequest, z16, j3, str, (QQCircleProfile$SetUserSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
        if (z17 && j3 == 0) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPrivacySubSettingUpdateEvent(10, z16));
            SimpleEventBus.getInstance().dispatchEvent(new QFSRecSwitchChangeEvent(z16));
        } else {
            com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
        }
    }

    private final void ea(int type, final int code, final boolean isChecked) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(type, !isChecked ? 1 : 0), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.bizparts.cz
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                da.ga(code, isChecked, baseRequest, z16, j3, str, (QQCircleProfile$SetUserSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(int i3, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
        if (z17 && j3 == 0) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSPrivacySubSettingUpdateEvent(i3, z16));
        } else {
            com.tencent.biz.qqcircle.utils.cj.b(false, j3, str);
        }
    }

    private final void ha() {
        QFSPrivateSubSettingBean qFSPrivateSubSettingBean = this.subSettingBean;
        if (qFSPrivateSubSettingBean != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : qFSPrivateSubSettingBean.getSwitchKeyList()) {
                if (str != null) {
                    switch (str.hashCode()) {
                        case -1912856166:
                            if (str.equals(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_RECOM_LIKE_FEED_TO_FRIENDS)) {
                                Q9(arrayList);
                                break;
                            } else {
                                break;
                            }
                        case -132657484:
                            if (str.equals(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_TEENAGE_MANAGER)) {
                                Z9(arrayList);
                                break;
                            } else {
                                break;
                            }
                        case 620652642:
                            if (str.equals(QFSPrivateSettingBean.KEY_SIMPLE_ITEM_CONTRACT_SWITCH)) {
                                T9(arrayList);
                                break;
                            } else {
                                break;
                            }
                        case 627782504:
                            if (str.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRAISED)) {
                                V9(arrayList);
                                break;
                            } else {
                                break;
                            }
                        case 1172139473:
                            if (str.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_SHOW_PRESENTATION_OFM)) {
                                X9(arrayList);
                                break;
                            } else {
                                break;
                            }
                        case 1271157943:
                            if (str.equals(QFSPrivateSettingBean.KEY_SWITCH_BUTTON_ENABLE_PERSONAL_RECOMMEND)) {
                                M9(arrayList);
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            com.tencent.biz.qqcircle.adapter.ak akVar = this.adapter;
            if (akVar != null) {
                akVar.k0(com.tencent.mobileqq.troop.utils.bg.f302144a.n(arrayList));
            }
            com.tencent.biz.qqcircle.adapter.ak akVar2 = this.adapter;
            if (akVar2 != null) {
                akVar2.updateData(qFSPrivateSubSettingBean.getOpMaskList());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPrivacySettingSubPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.y_2) {
            I9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QFSPrivateSubSettingBean qFSPrivateSubSettingBean;
        super.onInitView(rootView);
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (serializableExtra instanceof QFSPrivateSubSettingBean) {
            qFSPrivateSubSettingBean = (QFSPrivateSubSettingBean) serializableExtra;
        } else {
            qFSPrivateSubSettingBean = null;
        }
        this.subSettingBean = qFSPrivateSubSettingBean;
        ba(rootView);
        S9(rootView);
        ha();
    }
}

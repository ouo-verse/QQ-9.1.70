package com.tencent.mobileqq.statustitle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statustitle.i;
import com.tencent.mobileqq.statustitle.widget.TitleAreaLeftLayout;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0092\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0093\u0001B\u0010\u0012\u0006\u00108\u001a\u000201\u00a2\u0006\u0005\b\u0091\u0001\u00107J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u001c\u0010$\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010&\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010'\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010)\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0004H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00100\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030.0-j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030.`/H\u0016R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010B\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010;\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010;R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR$\u0010Y\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010a\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010i\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010q\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR$\u0010y\u001a\u0004\u0018\u00010r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR%\u0010\u0080\u0001\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR,\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001\u00a8\u0006\u0094\u0001"}, d2 = {"Lcom/tencent/mobileqq/statustitle/b;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "inflatedView", "", "K9", "J9", "I9", "N9", "H9", "Q9", "x9", "O9", "P9", "Lcom/tencent/mobileqq/statustitle/BeforeAccountChanged;", "event", "B9", "Lcom/tencent/mobileqq/statustitle/AfterAccountChanged;", "A9", "Lcom/tencent/mobileqq/statustitle/OnPostThemeChanged;", "E9", "Lcom/tencent/mobileqq/statustitle/OnConfigurationChanged;", "D9", "Lcom/tencent/mobileqq/statustitle/OnBannerChanged;", "C9", "Lcom/tencent/mobileqq/statustitle/OnTitleAreaHeadClick;", "F9", "Lcom/tencent/mobileqq/statustitle/UpdateLittleWorldEntry;", "G9", "M9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartStart", "onPartResume", "onPartPause", "onPartStop", "onPartDestroy", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/statustitle/d;", "d", "Lcom/tencent/mobileqq/statustitle/d;", "getIBaseStatusTitleBarCb", "()Lcom/tencent/mobileqq/statustitle/d;", "setIBaseStatusTitleBarCb", "(Lcom/tencent/mobileqq/statustitle/d;)V", "iBaseStatusTitleBarCb", "", "e", "Z", "L9", "()Z", "setDestroy", "(Z)V", "isDestroy", "f", "isRegisterListener", "setRegisterListener", "Lcom/tencent/mobileqq/resconfig/MainResourceConfig;", tl.h.F, "Lcom/tencent/mobileqq/resconfig/MainResourceConfig;", "mResConfig", "Lmqq/os/MqqHandler;", "i", "Lmqq/os/MqqHandler;", "mHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mBannerShow", "", BdhLogUtil.LogTag.Tag_Conn, "I", "mBannerColor", "Landroid/widget/RelativeLayout;", "D", "Landroid/widget/RelativeLayout;", "z9", "()Landroid/widget/RelativeLayout;", "setMTitleArea", "(Landroid/widget/RelativeLayout;)V", "mTitleArea", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "getMNickName", "()Landroid/widget/TextView;", "setMNickName", "(Landroid/widget/TextView;)V", "mNickName", "Lcom/tencent/mobileqq/statustitle/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/statustitle/g;", "getMNickNameAssistant", "()Lcom/tencent/mobileqq/statustitle/g;", "setMNickNameAssistant", "(Lcom/tencent/mobileqq/statustitle/g;)V", "mNickNameAssistant", "Lcom/tencent/mobileqq/statustitle/widget/TitleAreaLeftLayout;", "G", "Lcom/tencent/mobileqq/statustitle/widget/TitleAreaLeftLayout;", "getMNickNameAndStatusContainer", "()Lcom/tencent/mobileqq/statustitle/widget/TitleAreaLeftLayout;", "setMNickNameAndStatusContainer", "(Lcom/tencent/mobileqq/statustitle/widget/TitleAreaLeftLayout;)V", "mNickNameAndStatusContainer", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "getMOpenSession", "()Landroid/widget/ImageView;", "setMOpenSession", "(Landroid/widget/ImageView;)V", "mOpenSession", "Lcom/tencent/mobileqq/statustitle/i;", "Lcom/tencent/mobileqq/statustitle/i;", "getMOpenSessionAssistant", "()Lcom/tencent/mobileqq/statustitle/i;", "setMOpenSessionAssistant", "(Lcom/tencent/mobileqq/statustitle/i;)V", "mOpenSessionAssistant", "Lcom/tencent/mobileqq/statustitle/i$b;", "J", "Lcom/tencent/mobileqq/statustitle/i$b;", "getMOpenSessionCallback", "()Lcom/tencent/mobileqq/statustitle/i$b;", "setMOpenSessionCallback", "(Lcom/tencent/mobileqq/statustitle/i$b;)V", "mOpenSessionCallback", "Lgr2/a;", "K", "Lgr2/a;", "getMRightEntrance", "()Lgr2/a;", "setMRightEntrance", "(Lgr2/a;)V", "mRightEntrance", "<init>", "L", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private int mBannerColor;

    /* renamed from: D, reason: from kotlin metadata */
    private RelativeLayout mTitleArea;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mNickName;

    /* renamed from: F, reason: from kotlin metadata */
    private g mNickNameAssistant;

    /* renamed from: G, reason: from kotlin metadata */
    private TitleAreaLeftLayout mNickNameAndStatusContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView mOpenSession;

    /* renamed from: I, reason: from kotlin metadata */
    private i mOpenSessionAssistant;

    /* renamed from: J, reason: from kotlin metadata */
    private i.b mOpenSessionCallback;

    /* renamed from: K, reason: from kotlin metadata */
    private gr2.a mRightEntrance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private d iBaseStatusTitleBarCb;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isDestroy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isRegisterListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final MainResourceConfig mResConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MqqHandler mHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mBannerShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/statustitle/b$b", "Lcom/tencent/mobileqq/statustitle/i$b;", "", "a", "Landroid/widget/RelativeLayout;", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.statustitle.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8619b implements i.b {
        C8619b() {
        }

        @Override // com.tencent.mobileqq.statustitle.i.b
        public boolean a() {
            return b.this.getIsDestroy();
        }

        @Override // com.tencent.mobileqq.statustitle.i.b
        public RelativeLayout b() {
            return b.this.getMTitleArea();
        }
    }

    public b(d iBaseStatusTitleBarCb) {
        Intrinsics.checkNotNullParameter(iBaseStatusTitleBarCb, "iBaseStatusTitleBarCb");
        this.iBaseStatusTitleBarCb = iBaseStatusTitleBarCb;
        this.mResConfig = MainResourceConfig.INSTANCE.e();
    }

    private final void A9(AfterAccountChanged event) {
        O9();
        if (event.isSwitchAccount()) {
            g gVar = this.mNickNameAssistant;
            if (gVar != null) {
                gVar.k("accountChange");
            }
            gr2.a aVar = this.mRightEntrance;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    private final void B9(BeforeAccountChanged event) {
        i iVar = this.mOpenSessionAssistant;
        if (iVar != null) {
            iVar.i(true);
            iVar.d();
        }
        P9();
    }

    private final void C9(OnBannerChanged event) {
        this.mBannerShow = event.isShow();
        this.mBannerColor = event.getTextColor();
        N9();
    }

    private final void D9(OnConfigurationChanged event) {
        i iVar = this.mOpenSessionAssistant;
        if (iVar != null) {
            iVar.b();
        }
    }

    private final void E9(OnPostThemeChanged event) {
        i iVar = this.mOpenSessionAssistant;
        if (iVar != null) {
            iVar.i(true);
        }
        N9();
    }

    private final void F9(OnTitleAreaHeadClick event) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_red_tips_type", Integer.valueOf(event.getHasRedTouch() ? 1 : 0)));
        VideoReport.reportEvent("dt_clck", this.mNickNameAndStatusContainer, mapOf);
    }

    private final void G9(UpdateLittleWorldEntry event) {
        int b16;
        TitleAreaLeftLayout titleAreaLeftLayout = this.mNickNameAndStatusContainer;
        if (titleAreaLeftLayout != null) {
            ViewGroup.LayoutParams layoutParams = titleAreaLeftLayout.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                if (event.getShow()) {
                    b16 = bi.b(140);
                } else {
                    b16 = bi.b(100);
                }
                marginLayoutParams.rightMargin = b16;
                titleAreaLeftLayout.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private final void H9() {
        TitleAreaLeftLayout titleAreaLeftLayout = this.mNickNameAndStatusContainer;
        if (titleAreaLeftLayout != null) {
            VideoReport.setElementId(titleAreaLeftLayout, "em_sgrp_user_center_entrance");
            VideoReport.setElementExposePolicy(titleAreaLeftLayout, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(titleAreaLeftLayout, EndExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(titleAreaLeftLayout, ClickPolicy.REPORT_NONE);
        }
    }

    private final void I9() {
        TextView textView = this.mNickName;
        if (textView == null) {
            return;
        }
        g gVar = new g(textView);
        this.mNickNameAssistant = gVar;
        gVar.g("initNickNameAssistant");
    }

    private final void J9() {
        ImageView imageView = this.mOpenSession;
        if (imageView == null) {
            return;
        }
        C8619b c8619b = new C8619b();
        this.mOpenSessionCallback = c8619b;
        this.mOpenSessionAssistant = new i(imageView, c8619b);
    }

    private final void M9() {
        if (this.mBannerShow) {
            RelativeLayout relativeLayout = this.mTitleArea;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundDrawable(null);
            }
            g gVar = this.mNickNameAssistant;
            if (gVar != null) {
                gVar.q(this.mBannerColor);
            }
            i iVar = this.mOpenSessionAssistant;
            if (iVar != null) {
                iVar.l(this.mBannerColor);
            }
            gr2.a aVar = this.mRightEntrance;
            if (aVar != null) {
                aVar.d(this.mBannerColor);
            }
        }
    }

    private final void O9() {
        QLog.i("BaseStatusTitlePart", 1, "registerObservers, isRegisterListener:" + this.isRegisterListener);
        if (this.isRegisterListener) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            qQAppInterface.setHandler(b.class, this.mHandler);
            g gVar = this.mNickNameAssistant;
            if (gVar != null) {
                gVar.i(qQAppInterface, qQAppInterface.isLogin());
            }
            i iVar = this.mOpenSessionAssistant;
            if (iVar != null) {
                iVar.h(qQAppInterface, qQAppInterface.isLogin());
            }
            this.isRegisterListener = true;
        }
    }

    private final void Q9() {
        RelativeLayout relativeLayout = this.mTitleArea;
        if (relativeLayout != null) {
            MainResourceConfig mainResourceConfig = this.mResConfig;
            Context context = relativeLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            relativeLayout.setBackground(mainResourceConfig.p(context, relativeLayout.getBackground()));
            MainResourceConfig mainResourceConfig2 = this.mResConfig;
            Context context2 = relativeLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            int q16 = mainResourceConfig2.q(context2);
            if (relativeLayout.getLayoutParams() == null) {
                relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, q16));
            } else if (relativeLayout.getLayoutParams().height != q16) {
                relativeLayout.getLayoutParams().height = q16;
            }
        }
    }

    private final void x9() {
        if (SimpleUIUtil.isNowElderMode()) {
            g gVar = this.mNickNameAssistant;
            if (gVar != null) {
                gVar.d();
            }
            i iVar = this.mOpenSessionAssistant;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    /* renamed from: L9, reason: from getter */
    public final boolean getIsDestroy() {
        return this.isDestroy;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        QLog.i("BaseStatusTitlePart", 1, "onInitView, hashCode:" + hashCode());
        super.onInitView(rootView);
        PartIOCKt.registerIoc(this, this.iBaseStatusTitleBarCb, d.class);
        d dVar = (d) PartIOCKt.getIocInterface(this, d.class);
        ViewStub b16 = dVar != null ? dVar.b(rootView) : null;
        d dVar2 = (d) PartIOCKt.getIocInterface(this, d.class);
        this.mRightEntrance = dVar2 != null ? dVar2.a() : null;
        if (b16 != null) {
            b16.setLayoutResource(R.layout.f127124);
            View inflate = b16.inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate()");
            K9(inflate);
            O9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        QLog.i("BaseStatusTitlePart", 1, "onPartCreate, hashCode:" + hashCode());
        super.onPartCreate(activity, savedInstanceState);
        this.isDestroy = false;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        QLog.i("BaseStatusTitlePart", 1, "onPartDestroy, hashCode:" + hashCode());
        super.onPartDestroy(activity);
        this.isDestroy = true;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        P9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        QLog.i("BaseStatusTitlePart", 1, "onPartPause, hashCode:" + hashCode());
        super.onPartPause(activity);
        i iVar = this.mOpenSessionAssistant;
        if (iVar != null) {
            iVar.j();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        QLog.i("BaseStatusTitlePart", 1, "onPartResume, hashCode:" + hashCode());
        super.onPartResume(activity);
        g gVar = this.mNickNameAssistant;
        if (gVar != null) {
            gVar.k("onPartResume");
        }
        x9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(Activity activity) {
        QLog.i("BaseStatusTitlePart", 1, "onPartStart, hashCode:" + hashCode());
        super.onPartStart(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        QLog.i("BaseStatusTitlePart", 1, "onPartStop, hashCode:" + hashCode());
        super.onPartStop(activity);
        i iVar = this.mOpenSessionAssistant;
        if (iVar != null) {
            iVar.b();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.i("BaseStatusTitlePart", 1, "[onReceiveEvent] receive event:" + event);
        if (event instanceof GetNavigationBar) {
            ((GetNavigationBar) event).setNavigationBar(this.mTitleArea);
            return;
        }
        if (event instanceof BeforeAccountChanged) {
            B9((BeforeAccountChanged) event);
            return;
        }
        if (event instanceof AfterAccountChanged) {
            A9((AfterAccountChanged) event);
            return;
        }
        if (event instanceof OnPostThemeChanged) {
            E9((OnPostThemeChanged) event);
            return;
        }
        if (event instanceof OnConfigurationChanged) {
            D9((OnConfigurationChanged) event);
            return;
        }
        if (event instanceof OnBannerChanged) {
            C9((OnBannerChanged) event);
        } else if (event instanceof OnTitleAreaHeadClick) {
            F9((OnTitleAreaHeadClick) event);
        } else if (event instanceof UpdateLittleWorldEntry) {
            G9((UpdateLittleWorldEntry) event);
        }
    }

    /* renamed from: z9, reason: from getter */
    public final RelativeLayout getMTitleArea() {
        return this.mTitleArea;
    }

    private final void N9() {
        QLog.d("BaseStatusTitlePart", 1, "refreshStatusBarUIByTheme");
        g gVar = this.mNickNameAssistant;
        if (gVar != null) {
            gVar.p();
        }
        Q9();
        i iVar = this.mOpenSessionAssistant;
        if (iVar != null) {
            iVar.g();
        }
        gr2.a aVar = this.mRightEntrance;
        if (aVar != null) {
            aVar.a();
        }
        M9();
    }

    private final void P9() {
        QLog.i("BaseStatusTitlePart", 1, "unregisterObservers");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            qQAppInterface.setHandler(b.class, null);
            g gVar = this.mNickNameAssistant;
            if (gVar != null) {
                gVar.j(qQAppInterface);
            }
            i iVar = this.mOpenSessionAssistant;
            if (iVar != null) {
                iVar.k(qQAppInterface);
            }
            this.isRegisterListener = false;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GetNavigationBar.class, AfterAccountChanged.class, BeforeAccountChanged.class, OnPostThemeChanged.class, OnConfigurationChanged.class, OnBannerChanged.class, OnTitleAreaHeadClick.class, UpdateLittleWorldEntry.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    private final void K9(View inflatedView) {
        RelativeLayout relativeLayout = (RelativeLayout) inflatedView.findViewById(R.id.t57);
        IphoneTitleBarActivity.setLayerType(relativeLayout);
        relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
        this.mTitleArea = relativeLayout;
        TextView textView = (TextView) inflatedView.findViewById(R.id.f18242g);
        if (textView != null) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
            SimpleModeHelper.n(textView);
        } else {
            textView = null;
        }
        this.mNickName = textView;
        this.mNickNameAndStatusContainer = (TitleAreaLeftLayout) inflatedView.findViewById(R.id.f17891i);
        this.mOpenSession = (ImageView) inflatedView.findViewById(R.id.f17490f);
        gr2.a aVar = this.mRightEntrance;
        if (aVar != null) {
            View findViewById = inflatedView.findViewById(R.id.f18041x);
            Intrinsics.checkNotNullExpressionValue(findViewById, "inflatedView.findViewByI\u2026itle_right_entrance_stub)");
            aVar.b(this, (ViewStub) findViewById);
        }
        I9();
        J9();
        N9();
        H9();
    }
}

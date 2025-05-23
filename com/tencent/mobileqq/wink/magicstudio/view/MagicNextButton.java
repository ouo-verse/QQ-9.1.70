package com.tencent.mobileqq.wink.magicstudio.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.wink.share.WinkShareManager;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AB\u001b\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u00a2\u0006\u0004\b@\u0010DB#\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u0012\u0006\u0010E\u001a\u00020$\u00a2\u0006\u0004\b@\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J6\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\"R$\u0010(\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'RA\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00109\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b\u001c\u00106\"\u0004\b7\u00108R[\u0010=\u001a;\u0012/\u0012-\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010-\u001a\u0004\b;\u0010/\"\u0004\b<\u00101\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/MagicNextButton;", "Landroid/widget/FrameLayout;", "", "j", "i", "", "action", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "map", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "buttonInfo", "l", "", "d", "J", "lastClickTime", "", "e", "Z", "shareIsShowing", "f", "Ljava/lang/String;", "TAG", "Lcom/tencent/biz/qui/quibutton/QUIButton;", tl.h.F, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "buttonView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "buttonTextView", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "innerDealActionTypeList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "D", "Lkotlin/jvm/functions/Function1;", "g", "()Lkotlin/jvm/functions/Function1;", "setClick", "(Lkotlin/jvm/functions/Function1;)V", "click", "Lkotlin/Function0;", "E", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setShareCallBack", "(Lkotlin/jvm/functions/Function0;)V", "shareCallBack", UserInfo.SEX_FEMALE, "getReportCallBack", "setReportCallBack", "reportCallBack", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicNextButton extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> innerDealActionTypeList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<? super MagicStudioButtonInfo, Unit> click;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> shareCallBack;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function1<? super HashMap<String, Object>, Unit> reportCallBack;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean shareIsShowing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIButton buttonView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView buttonTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MagicStudioButtonInfo buttonInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicNextButton(@NotNull Context context) {
        super(context);
        ArrayList<Integer> arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "MagicNextButton";
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(1, 2, 4);
        this.innerDealActionTypeList = arrayListOf;
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i() {
        byte b16;
        byte b17;
        Object obj;
        Throwable th5;
        String str;
        MagicStudioButtonInfo magicStudioButtonInfo = this.buttonInfo;
        boolean z16 = false;
        if (magicStudioButtonInfo != null && magicStudioButtonInfo.getActionType() == 4) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false) {
            BaseApplication context = BaseApplication.getContext();
            MagicStudioButtonInfo magicStudioButtonInfo2 = this.buttonInfo;
            Intrinsics.checkNotNull(magicStudioButtonInfo2);
            QQToast.makeText(context, magicStudioButtonInfo2.getSubtitleString(), 0).show();
            return;
        }
        MagicStudioButtonInfo magicStudioButtonInfo3 = this.buttonInfo;
        if (magicStudioButtonInfo3 != null && magicStudioButtonInfo3.getActionType() == 1) {
            b17 = true;
        } else {
            b17 = false;
        }
        FragmentActivity fragmentActivity = null;
        String str2 = null;
        if (b17 != false) {
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) JumpActivity.class);
            MagicStudioButtonInfo magicStudioButtonInfo4 = this.buttonInfo;
            if (magicStudioButtonInfo4 != null) {
                str2 = magicStudioButtonInfo4.getSchemaUrl();
            }
            intent.setData(Uri.parse(String.valueOf(str2)));
            intent.addFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
            return;
        }
        MagicStudioButtonInfo magicStudioButtonInfo5 = this.buttonInfo;
        if (magicStudioButtonInfo5 != null && magicStudioButtonInfo5.getActionType() == 2) {
            z16 = true;
        }
        if (z16 && !this.shareIsShowing) {
            this.shareIsShowing = true;
            Context context2 = getContext();
            if (context2 instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context2;
            }
            FragmentActivity fragmentActivity2 = fragmentActivity;
            if (fragmentActivity2 != null) {
                com.tencent.mobileqq.wink.share.c cVar = new com.tencent.mobileqq.wink.share.c();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    obj = new Gson().fromJson(com.tencent.mobileqq.wink.magicstudio.model.h.f323788a.a(), (Class<Object>) com.tencent.mobileqq.wink.share.c.class);
                    Intrinsics.checkNotNullExpressionValue(obj, "Gson().fromJson(PrivateP\u2026H5ShareModel::class.java)");
                } catch (Throwable th6) {
                    obj = cVar;
                    th5 = th6;
                }
                try {
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th7) {
                    th5 = th7;
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                    if (!r93.h.f430993a.g()) {
                    }
                    WinkShareManager winkShareManager = WinkShareManager.f326323a;
                    com.tencent.mobileqq.wink.share.c cVar2 = (com.tencent.mobileqq.wink.share.c) obj;
                    winkShareManager.p(fragmentActivity2, cVar2, winkShareManager.h(cVar2, "magic_studio_share_info", 52129, str), 2, new MagicNextButton$handlerClickAction$1$2(this), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.MagicNextButton$handlerClickAction$1$3
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            MagicNextButton.this.shareIsShowing = false;
                        }
                    });
                }
                if (!r93.h.f430993a.g()) {
                    str = "qzoneMagicStudio";
                } else {
                    str = QQWinkConstants.BUSINESS_MAIGC_STUDIO;
                }
                WinkShareManager winkShareManager2 = WinkShareManager.f326323a;
                com.tencent.mobileqq.wink.share.c cVar22 = (com.tencent.mobileqq.wink.share.c) obj;
                winkShareManager2.p(fragmentActivity2, cVar22, winkShareManager2.h(cVar22, "magic_studio_share_info", 52129, str), 2, new MagicNextButton$handlerClickAction$1$2(this), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.MagicNextButton$handlerClickAction$1$3
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        MagicNextButton.this.shareIsShowing = false;
                    }
                });
            }
        }
    }

    private final void j() {
        LayoutInflater.from(getContext()).inflate(R.layout.dtt, this);
        this.buttonView = (QUIButton) findViewById(R.id.yvx);
        this.buttonTextView = (TextView) findViewById(R.id.f166171yw3);
        QUIButton qUIButton = this.buttonView;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.view.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MagicNextButton.k(MagicNextButton.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final MagicNextButton this$0, View view) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (FastClickUtils.isFastDoubleClick(this$0.TAG + "setOnClickListener", 500L)) {
            w53.b.c(this$0.TAG, "buttonInfo isFastDoubleClick");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this$0.lastClickTime >= 100) {
                this$0.lastClickTime = currentTimeMillis;
                MagicStudioButtonInfo magicStudioButtonInfo = this$0.buttonInfo;
                if (magicStudioButtonInfo != null) {
                    num = Integer.valueOf(magicStudioButtonInfo.getActionType());
                } else {
                    num = null;
                }
                o(this$0, String.valueOf(num), null, 2, null);
                WinkMagicStudioUtils winkMagicStudioUtils = WinkMagicStudioUtils.f323888a;
                if (winkMagicStudioUtils.j(this$0.buttonInfo)) {
                    Context context = this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    WinkMagicStudioUtils.q(winkMagicStudioUtils, context, null, null, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.MagicNextButton$initView$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            MagicStudioButtonInfo magicStudioButtonInfo2;
                            MagicStudioButtonInfo magicStudioButtonInfo3;
                            ArrayList arrayList;
                            MagicStudioButtonInfo magicStudioButtonInfo4;
                            magicStudioButtonInfo2 = MagicNextButton.this.buttonInfo;
                            if (magicStudioButtonInfo2 != null) {
                                arrayList = MagicNextButton.this.innerDealActionTypeList;
                                magicStudioButtonInfo4 = MagicNextButton.this.buttonInfo;
                                Intrinsics.checkNotNull(magicStudioButtonInfo4);
                                if (arrayList.contains(Integer.valueOf(magicStudioButtonInfo4.getActionType()))) {
                                    MagicNextButton.this.i();
                                    return;
                                }
                            }
                            Function1<MagicStudioButtonInfo, Unit> g16 = MagicNextButton.this.g();
                            if (g16 != null) {
                                magicStudioButtonInfo3 = MagicNextButton.this.buttonInfo;
                                g16.invoke(magicStudioButtonInfo3);
                            }
                        }
                    }, 14, null);
                } else {
                    MagicStudioButtonInfo magicStudioButtonInfo2 = this$0.buttonInfo;
                    if (magicStudioButtonInfo2 != null) {
                        ArrayList<Integer> arrayList = this$0.innerDealActionTypeList;
                        Intrinsics.checkNotNull(magicStudioButtonInfo2);
                        if (arrayList.contains(Integer.valueOf(magicStudioButtonInfo2.getActionType()))) {
                            this$0.i();
                        }
                    }
                    Function1<? super MagicStudioButtonInfo, Unit> function1 = this$0.click;
                    if (function1 != null) {
                        function1.invoke(this$0.buttonInfo);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void m() {
        String str;
        QUIButton qUIButton = this.buttonView;
        String str2 = null;
        if (qUIButton != null) {
            MagicStudioButtonInfo magicStudioButtonInfo = this.buttonInfo;
            if (magicStudioButtonInfo != null) {
                str = magicStudioButtonInfo.getBtnString();
            } else {
                str = null;
            }
            qUIButton.setText(str);
        }
        TextView textView = this.buttonTextView;
        if (textView != null) {
            MagicStudioButtonInfo magicStudioButtonInfo2 = this.buttonInfo;
            if (magicStudioButtonInfo2 != null) {
                str2 = magicStudioButtonInfo2.getSubtitleString();
            }
            textView.setText(str2);
        }
        MagicStudioButtonInfo magicStudioButtonInfo3 = this.buttonInfo;
        boolean z16 = false;
        if (magicStudioButtonInfo3 != null && magicStudioButtonInfo3.getActionType() == 4) {
            z16 = true;
        }
        if (z16) {
            QUIButton qUIButton2 = this.buttonView;
            if (qUIButton2 != null) {
                qUIButton2.setBackgroundDisabled();
                return;
            }
            return;
        }
        QUIButton qUIButton3 = this.buttonView;
        if (qUIButton3 != null) {
            qUIButton3.o();
        }
    }

    private final void n(String action, HashMap<String, Object> map) {
        String str;
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_status", action);
        MagicStudioButtonInfo magicStudioButtonInfo = this.buttonInfo;
        if (magicStudioButtonInfo != null) {
            str = magicStudioButtonInfo.getSubtitleString();
        } else {
            str = null;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TITLE, String.valueOf(str));
        for (String it : buildElementParams.keySet()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            map.put(it, String.valueOf(buildElementParams.get(it)));
        }
        Function1<? super HashMap<String, Object>, Unit> function1 = this.reportCallBack;
        if (function1 != null) {
            function1.invoke(map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void o(MagicNextButton magicNextButton, String str, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            hashMap = new HashMap();
        }
        magicNextButton.n(str, hashMap);
    }

    @Nullable
    public final Function1<MagicStudioButtonInfo, Unit> g() {
        return this.click;
    }

    @Nullable
    public final Function0<Unit> h() {
        return this.shareCallBack;
    }

    public final void l(@Nullable MagicStudioButtonInfo buttonInfo) {
        if (buttonInfo == null) {
            w53.b.c(this.TAG, "buttonInfo == null");
        }
        this.buttonInfo = buttonInfo;
        m();
    }

    public final void setClick(@Nullable Function1<? super MagicStudioButtonInfo, Unit> function1) {
        this.click = function1;
    }

    public final void setReportCallBack(@Nullable Function1<? super HashMap<String, Object>, Unit> function1) {
        this.reportCallBack = function1;
    }

    public final void setShareCallBack(@Nullable Function0<Unit> function0) {
        this.shareCallBack = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicNextButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        ArrayList<Integer> arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "MagicNextButton";
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(1, 2, 4);
        this.innerDealActionTypeList = arrayListOf;
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicNextButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        ArrayList<Integer> arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "MagicNextButton";
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(1, 2, 4);
        this.innerDealActionTypeList = arrayListOf;
        j();
    }
}

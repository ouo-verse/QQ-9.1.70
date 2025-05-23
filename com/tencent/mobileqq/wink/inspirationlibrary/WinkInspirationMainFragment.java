package com.tencent.mobileqq.wink.inspirationlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.WinkExodus;
import com.tencent.mobileqq.wink.inspirationlibrary.part.WinkInspirationBottomNavigationPart;
import com.tencent.mobileqq.wink.inspirationlibrary.part.g;
import com.tencent.mobileqq.wink.inspirationlibrary.part.j;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.templatelibrary.viewmodel.WinkTemplateViewModel;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.utils.WinkDtParamsUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.utils.LiveDataExtKt;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r93.h;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, scene = QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_TEMPLATE)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u001a\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0014R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00105\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/WinkInspirationMainFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/winkreport/crashreport/IWinkCrashReportCallback;", "", "sh", "", "getPageId", "uh", "Landroid/view/View;", "contentView", "yh", "", "getContentLayoutId", "getLogTag", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "onBackEvent", "getStatusBarColor", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/wink/QQWinkConfig;", "winkConfig", "Lcom/tencent/mobileqq/wink/templatelibrary/viewmodel/WinkTemplateViewModel;", "D", "Lcom/tencent/mobileqq/wink/templatelibrary/viewmodel/WinkTemplateViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/wink/templatelibrary/viewmodel/WinkTemplateViewModel;", "setViewModel", "(Lcom/tencent/mobileqq/wink/templatelibrary/viewmodel/WinkTemplateViewModel;)V", "viewModel", "E", "Landroid/view/View;", "getSkeleton", "()Landroid/view/View;", "setSkeleton", "(Landroid/view/View;)V", "skeleton", UserInfo.SEX_FEMALE, "getCloseBtn", "setCloseBtn", "closeBtn", "<init>", "()V", "H", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkInspirationMainFragment extends ImmersivePartFragment implements IWinkCrashReportCallback {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy winkConfig;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WinkTemplateViewModel viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View skeleton;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View closeBtn;

    @NotNull
    public Map<Integer, View> G = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/inspirationlibrary/WinkInspirationMainFragment$a;", "", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "winkConfig", "Lcom/tencent/mobileqq/wink/inspirationlibrary/WinkInspirationMainFragment;", "a", "", "ARG_QQ_WINK_CONFIG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.inspirationlibrary.WinkInspirationMainFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkInspirationMainFragment a(@NotNull QQWinkConfig winkConfig) {
            Intrinsics.checkNotNullParameter(winkConfig, "winkConfig");
            WinkInspirationMainFragment winkInspirationMainFragment = new WinkInspirationMainFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_qq_wink_config", winkConfig);
            winkInspirationMainFragment.setArguments(bundle);
            return winkInspirationMainFragment;
        }

        Companion() {
        }
    }

    public WinkInspirationMainFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQWinkConfig>() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.WinkInspirationMainFragment$winkConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQWinkConfig invoke() {
                Bundle arguments = WinkInspirationMainFragment.this.getArguments();
                QQWinkConfig qQWinkConfig = arguments != null ? (QQWinkConfig) arguments.getParcelable("arg_qq_wink_config") : null;
                return qQWinkConfig == null ? new QQWinkConfig(null, null, null, null, 15, null) : qQWinkConfig;
            }
        });
        this.winkConfig = lazy;
    }

    private final String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_TEMPLATE_LIBRARY_PAGE;
    }

    private final void sh() {
        Bundle bundle;
        Intent intent;
        Context context = getContext();
        if (context != null) {
            WinkExodus m3 = WinkContext.INSTANCE.d().m();
            FragmentActivity activity = getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                bundle = intent.getExtras();
            } else {
                bundle = null;
            }
            m3.j(context, bundle);
        }
        d.f322989a.a(false);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
            activity2.overridePendingTransition(0, R.anim.f155066i1);
        }
    }

    private final QQWinkConfig th() {
        return (QQWinkConfig) this.winkConfig.getValue();
    }

    private final void uh() {
        Serializable serializable;
        Intent intent;
        FragmentActivity activity = getActivity();
        HashMap hashMap = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_attrs");
        } else {
            serializable = null;
        }
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        }
        WinkDtParamsUtils.initParamByKey(hashMap, "xsj_operation_activity_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(WinkInspirationMainFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("WinkInspirationMainFragment", 1, "[onViewCreated] data got, hide skeleton");
        View view = this$0.skeleton;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(WinkInspirationMainFragment this$0) {
        String str;
        boolean z16;
        Intent intent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("WinkInspirationMainFragment", 1, "[onViewCreated] post request");
        WinkTemplateViewModel winkTemplateViewModel = this$0.viewModel;
        if (winkTemplateViewModel != null) {
            Activity hostActivity = this$0.getHostActivity();
            if (hostActivity == null || (intent = hostActivity.getIntent()) == null || (str = intent.getStringExtra(QQWinkConstants.INSPIRATION_SERVICE_ID)) == null) {
                str = "MqKuaishanTemplate";
            }
            Intrinsics.checkNotNullExpressionValue(str, "hostActivity?.intent?.ge\u2026EMPLATE_LIBRARY_SERVICEID");
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i("WinkInspirationMainFragment", 1, "[onViewCreated] serviceId=" + str + " ");
                winkTemplateViewModel.W1(str);
                winkTemplateViewModel.T1(45, 0);
                return;
            }
            throw new InvalidParameterException("no serviceId");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(WinkInspirationMainFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void yh(View contentView) {
        String str;
        String stringExtra;
        Intent intent;
        HashMap hashMap = new HashMap();
        try {
            if (getActivity() != null) {
                HashMap<String, Object> params = WinkDatongCurrentParams.params;
                Intrinsics.checkNotNullExpressionValue(params, "params");
                FragmentActivity activity = getActivity();
                if (activity != null && (intent = activity.getIntent()) != null) {
                    str = intent.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE);
                } else {
                    str = null;
                }
                params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, str);
                Intent intent2 = requireActivity().getIntent();
                if (intent2 != null && (stringExtra = intent2.getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_ENTRANCE)) != null) {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_ENTRANCE, stringExtra);
                }
            }
        } catch (Exception e16) {
            QLog.e("WinkInspirationMainFragment", 1, "registerDatongPage error, " + e16);
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, getPageId());
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE);
        Intrinsics.checkNotNullExpressionValue(obj, "get(WinkDaTongReportCons\u2026J_IS_FROM_WHICH_ENTRANCE)");
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_WHICH_ENTRANCE, obj);
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(hashMap, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    public void _$_clearFindViewByIdCache() {
        this.G.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new p53.b[]{new WinkInspirationBottomNavigationPart(th()), new g(), new j()});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i5r;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkInspirationMainFragment";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ViewExKt.g();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        za3.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        sh();
        return true;
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateReport() {
        za3.a.c(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateViewReport() {
        za3.a.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCustomReport(int i3) {
        za3.a.e(this, i3);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        za3.a.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        za3.a.g(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        za3.a.h(this, z16);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        za3.a.i(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Intent intent;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        t53.a.c(intent, new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.WinkInspirationMainFragment$onResume$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull WinkDc5507ReportData.a dc5507Report) {
                Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                dc5507Report.b(1003);
                dc5507Report.j(1);
            }
        });
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        za3.a.j(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        MutableLiveData<List<MetaCategory>> Q1;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WinkTemplateViewModel winkTemplateViewModel = (WinkTemplateViewModel) getViewModel(WinkTemplateViewModel.class);
        this.viewModel = winkTemplateViewModel;
        if (winkTemplateViewModel == null) {
            QLog.e("WinkInspirationMainFragment", 1, "[onViewCreated] invalid viewModel");
        }
        WinkTemplateViewModel winkTemplateViewModel2 = this.viewModel;
        if (winkTemplateViewModel2 != null && (Q1 = winkTemplateViewModel2.Q1()) != null) {
            LiveDataExtKt.a(Q1, this, new Observer() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkInspirationMainFragment.vh(WinkInspirationMainFragment.this, (List) obj);
                }
            });
        }
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.b
            @Override // java.lang.Runnable
            public final void run() {
                WinkInspirationMainFragment.wh(WinkInspirationMainFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        TextView textView;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        l.f();
        setStatusBarTextColor();
        View findViewById = contentView.findViewById(R.id.f124377j7);
        this.skeleton = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        View findViewById2 = contentView.findViewById(R.id.f124257iv);
        this.closeBtn = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.inspirationlibrary.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkInspirationMainFragment.xh(WinkInspirationMainFragment.this, view);
                }
            });
        }
        h hVar = h.f430993a;
        if (hVar.i(getActivity()) && hVar.g() && (textView = (TextView) contentView.findViewById(R.id.jq_)) != null) {
            textView.setText(R.string.f241337rl);
        }
        if (uq3.c.f6()) {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).preDownloadAllNonEssentialBundles();
        }
        uh();
        yh(contentView);
        d.f322989a.a(true);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        za3.a.k(this);
    }
}

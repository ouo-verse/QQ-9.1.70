package com.tencent.mobileqq.search.base.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/base/activity/SearchMoreActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "", "initFragment", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "a0", "Lkotlin/Lazy;", "F2", "()Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "titleNav", "<init>", "()V", "b0", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchMoreActivity extends QBaseActivity {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy titleNav;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/base/activity/SearchMoreActivity$a;", "", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/search/base/fragment/BaseSearchFragment;", "fragClass", "", VasWebviewConstants.KEY_PAGE_TITLE, "Landroid/os/Bundle;", "argsBundle", "", "a", "KEY_FRAG_ARGS", "Ljava/lang/String;", "KEY_FRAG_CLASS", "KEY_PAGE_TITLE", "TAG", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.base.activity.SearchMoreActivity$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Class<? extends BaseSearchFragment<?>> fragClass, @Nullable String pageTitle, @Nullable Bundle argsBundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragClass, "fragClass");
            Intent intent = new Intent(context, (Class<?>) SearchMoreActivity.class);
            intent.putExtra("key_fragment_class", fragClass.getName());
            intent.putExtra("key_fragment_args", argsBundle);
            intent.putExtra("key_page_title", pageTitle);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }

        Companion() {
        }
    }

    public SearchMoreActivity() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUISecNavBar>() { // from class: com.tencent.mobileqq.search.base.activity.SearchMoreActivity$titleNav$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUISecNavBar invoke() {
                return (QUISecNavBar) SearchMoreActivity.this.findViewById(R.id.f98715nu);
            }
        });
        this.titleNav = lazy;
    }

    private final QUISecNavBar F2() {
        Object value = this.titleNav.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-titleNav>(...)");
        return (QUISecNavBar) value;
    }

    private final void initFragment() {
        String stringExtra = getIntent().getStringExtra("key_fragment_class");
        if (stringExtra != null) {
            Object newInstance = Class.forName(stringExtra).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.search.base.fragment.BaseSearchFragment<*>");
            BaseSearchFragment baseSearchFragment = (BaseSearchFragment) newInstance;
            Bundle bundleExtra = getIntent().getBundleExtra("key_fragment_args");
            if (bundleExtra != null) {
                baseSearchFragment.setArguments(bundleExtra);
            }
            baseSearchFragment.setActivityContentView(findViewById(R.id.root_layout));
            QUISecNavBar F2 = F2();
            F2.R(this);
            F2.setLeftType(2);
            F2.setCenterType(1);
            F2.setRightType(0);
            String stringExtra2 = getIntent().getStringExtra("key_page_title");
            if (stringExtra2 != null) {
                F2.setCenterText(stringExtra2);
            }
            F2.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.search.base.activity.SearchMoreActivity$initFragment$1$2$2

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes18.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f282798a;

                    static {
                        int[] iArr = new int[BaseAction.values().length];
                        try {
                            iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f282798a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View v3, @NotNull BaseAction action) {
                    Intrinsics.checkNotNullParameter(v3, "v");
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (a.f282798a[action.ordinal()] == 1) {
                        SearchMoreActivity.this.finish();
                    }
                }
            });
            View g16 = F2.g(BaseAction.ACTION_LEFT_BUTTON);
            VideoReport.setElementId(g16, "em_bas_back");
            VideoReport.setElementClickPolicy(g16, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(g16, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(g16, EndExposurePolicy.REPORT_ALL);
            getSupportFragmentManager().beginTransaction().replace(R.id.ckj, baseSearchFragment).commitAllowingStateLoss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        ca.a(this);
        super.doOnCreate(savedInstanceState);
        super.setContentView(R.layout.f168863h35);
        initFragment();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

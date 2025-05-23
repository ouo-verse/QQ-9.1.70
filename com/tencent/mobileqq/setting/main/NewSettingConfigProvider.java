package com.tencent.mobileqq.setting.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment;
import com.tencent.mobileqq.setting.main.processor.AboutItemProcessor;
import com.tencent.mobileqq.setting.main.processor.GXHItemProcessor;
import com.tencent.mobileqq.setting.main.processor.MsgNotifyItemProcessor;
import com.tencent.mobileqq.setting.main.processor.e;
import com.tencent.mobileqq.setting.main.processor.h;
import com.tencent.mobileqq.setting.main.processor.t;
import com.tencent.mobileqq.setting.main.processor.v;
import com.tencent.mobileqq.setting.processor.SettingConfigProvider;
import com.tencent.mobileqq.setting.processor.b;
import com.tencent.mobileqq.setting.processor.c;
import com.tencent.mobileqq.setting.processor.j;
import com.tencent.mobileqq.setting.utils.o;
import com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/setting/main/NewSettingConfigProvider;", "Lcom/tencent/mobileqq/setting/processor/SettingConfigProvider;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/setting/processor/j;", "t", "w", "u", "y", "v", ReportConstant.COSTREPORT_PREFIX, "", "Lcom/tencent/mobileqq/setting/processor/b;", "f", "Landroid/view/View;", "view", "", HippyTKDListViewAdapter.X, "b", "e", "Landroid/view/View;", "quiNavBar", "<init>", "()V", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class NewSettingConfigProvider extends SettingConfigProvider {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View quiNavBar;

    private final j s(Context context) {
        String string = context.getString(R.string.r2g);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.qqstr_qqsettin_22b44ae2)");
        final j jVar = new j(context, 17, string, 0, 8, null);
        jVar.z(new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$debugToolItemProcessor$1$1
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
                Activity e16 = j.this.e();
                if (e16 != null) {
                    RouteUtils.startActivity(e16, new Intent(), "/debug/envSwitchActivity");
                }
            }
        });
        jVar.B(false);
        return jVar;
    }

    private final j t(Context context) {
        String string = context.getString(R.string.frw);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.qq_setting_general)");
        final j jVar = new j(context, 7, string, R.drawable.qui_tuning);
        jVar.z(new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$newgeneralItemProcessor$1$1
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
                Activity e16 = j.this.e();
                if (e16 != null) {
                    QPublicFragmentActivity.start(e16, new Intent(), GeneralSettingFragment.class);
                }
                c h16 = j.this.h(9);
                v vVar = h16 instanceof v ? (v) h16 : null;
                if (vVar != null) {
                    vVar.z();
                }
                o oVar = o.f286768a;
                o.k(oVar, "0X800B832", 0, null, null, null, null, 62, null);
                oVar.c("CliOper", "Setting_tab", "0X8009C04", (r20 & 8) != 0 ? 0 : 0, (r20 & 16) != 0 ? "" : null, (r20 & 32) != 0 ? "" : null, (r20 & 64) != 0 ? "" : null, (r20 & 128) != 0 ? "" : null);
            }
        });
        jVar.A(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$newgeneralItemProcessor$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                o.m(o.f286768a, it, "em_bas_be_common", null, false, 8, null);
            }
        });
        return jVar;
    }

    private final j u(Context context) {
        String string = context.getString(R.string.f20456539);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026etting_personal_infolist)");
        final j jVar = new j(context, 11, string, R.drawable.qui_files);
        jVar.z(new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$personalInfoListItemProcessor$1$1
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
                Activity e16 = j.this.e();
                if (e16 != null) {
                    Intent intent = new Intent();
                    intent.putExtra("url", "https://accounts.qq.com/information/collectionlist?_wv=0");
                    intent.putExtra("hide_more_button", true);
                    RouteUtils.startActivity(e16, intent, RouterConstants.UI_ROUTE_BROWSER);
                }
            }
        });
        jVar.A(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$personalInfoListItemProcessor$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                o.m(o.f286768a, it, "em_bas_personal_information_collection_list", null, false, 8, null);
            }
        });
        return jVar;
    }

    private final j v(Context context) {
        String string = context.getString(R.string.f2045753_);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026l_information_protection)");
        final j jVar = new j(context, 13, string, R.drawable.qui_collection_form);
        jVar.z(new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$personalInfoProtectItemProcessor$1$1
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
                Activity e16 = j.this.e();
                if (e16 != null) {
                    Intent intent = new Intent();
                    intent.putExtra("url", "https://accounts.qq.com/info/management/index?_wv=3&_wwv=128");
                    intent.putExtra("hide_more_button", true);
                    RouteUtils.startActivity(e16, intent, RouterConstants.UI_ROUTE_BROWSER);
                }
                o.k(o.f286768a, "0X800BFC0", 0, null, "0", "0", null, 38, null);
            }
        });
        jVar.A(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$personalInfoProtectItemProcessor$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                o oVar = o.f286768a;
                o.k(oVar, "0X800BFBF", 0, null, null, null, null, 62, null);
                o.m(oVar, it, "em_bas_personal_information_protection_settings", null, false, 8, null);
            }
        });
        return jVar;
    }

    private final j w(Context context) {
        String string = context.getString(R.string.f21974679);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.qzone_privacy_setting)");
        final j jVar = new j(context, 6, string, R.drawable.qui_secrecy);
        jVar.z(new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$privacyItemProcessor$1$1
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
                Activity e16 = j.this.e();
                if (e16 != null) {
                    QPublicFragmentActivity.start(e16, new Intent(), PermissionPrivacyFragmentKotlin.class);
                }
                o.f286768a.c("CliOper", "Setting_tab", "Clk_privacy_safe", (r20 & 8) != 0 ? 0 : 0, (r20 & 16) != 0 ? "" : null, (r20 & 32) != 0 ? "" : null, (r20 & 64) != 0 ? "" : null, (r20 & 128) != 0 ? "" : null);
            }
        });
        jVar.A(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$privacyItemProcessor$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                o.m(o.f286768a, it, "em_bas_privacy_settings", null, false, 8, null);
            }
        });
        return jVar;
    }

    private final j y(Context context) {
        String string = context.getString(R.string.f2047253o);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ting_thirdpart_sharelist)");
        final j jVar = new j(context, 12, string, R.drawable.qui_route);
        jVar.z(new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$thirdPartyShareListItemProcessor$1$1
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
                Activity e16 = j.this.e();
                if (e16 != null) {
                    Intent intent = new Intent();
                    intent.putExtra("url", AppConstants.URL.THIRDPARTY_INFORMATION_SHARING);
                    intent.putExtra("hide_more_button", true);
                    RouteUtils.startActivity(e16, intent, RouterConstants.UI_ROUTE_BROWSER);
                }
            }
        });
        jVar.A(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.setting.main.NewSettingConfigProvider$thirdPartyShareListItemProcessor$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                o.m(o.f286768a, it, "em_bas_third_party_personal_information_sharing_list", null, false, 8, null);
            }
        });
        return jVar;
    }

    @Override // com.tencent.mobileqq.setting.processor.SettingConfigProvider, com.tencent.mobileqq.setting.processor.f
    /* renamed from: b, reason: from getter */
    public View getQuiNavBar() {
        return this.quiNavBar;
    }

    public final void x(View view) {
        this.quiNavBar = view;
    }

    @Override // com.tencent.mobileqq.setting.processor.SettingConfigProvider
    public List<b> f(Context context) {
        List mutableListOf;
        List mutableListOf2;
        List mutableListOf3;
        List mutableListOf4;
        List mutableListOf5;
        List mutableListOf6;
        List mutableListOf7;
        List<b> mutableListOf8;
        Intrinsics.checkNotNullParameter(context, "context");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new t(context));
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(new e(context, true));
        mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf(new MsgNotifyItemProcessor(context), new com.tencent.mobileqq.setting.main.processor.o(context), new GXHItemProcessor(context), t(context));
        mutableListOf4 = CollectionsKt__CollectionsKt.mutableListOf(w(context), u(context), y(context), v(context));
        mutableListOf5 = CollectionsKt__CollectionsKt.mutableListOf(new AboutItemProcessor(context));
        mutableListOf6 = CollectionsKt__CollectionsKt.mutableListOf(new h(context));
        mutableListOf7 = CollectionsKt__CollectionsKt.mutableListOf(s(context));
        mutableListOf8 = CollectionsKt__CollectionsKt.mutableListOf(new b(mutableListOf, null, null, 6, null), new b(mutableListOf2, null, null, 6, null), new b(mutableListOf3, "\u529f\u80fd", null, 4, null), new b(mutableListOf4, "\u9690\u79c1", null, 4, null), new b(mutableListOf5, null, null, 6, null), new b(mutableListOf6, null, null, 6, null), new b(mutableListOf7, null, null, 6, null));
        return mutableListOf8;
    }
}

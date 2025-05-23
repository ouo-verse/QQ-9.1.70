package com.tencent.mobileqq.settings.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002JH\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\b\b\u0000\u0010\u0005*\u00020\u0004\"\b\b\u0001\u0010\u0007*\u00020\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0002JT\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\u001a\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"\u00a2\u0006\u0004\b$\u0010%R\u001a\u0010*\u001a\u00020\u000e8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u00100\u001a\u00020+8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00102\u001a\u00020+8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b1\u0010/R\u001a\u00105\u001a\u00020+8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/R\u001a\u00108\u001a\u00020+8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b6\u0010-\u001a\u0004\b7\u0010/R\u001a\u0010;\u001a\u00020+8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b9\u0010-\u001a\u0004\b:\u0010/R\u001a\u0010>\u001a\u00020+8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b<\u0010-\u001a\u0004\b=\u0010/R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010@R\"\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/settings/fragment/PrivacyInterNewSetFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "", "initData", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lkotlin/Function0;", "onExpo", "Jh", "", "leftText", "", "leftIcon", "rightText", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Lh", "Lcom/tencent/mobileqq/widget/listitem/a;", "Fh", "Ih", "Landroid/content/Intent;", "troopIntent", "Hh", "Dh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Eh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "J", "I", "Gh", "()I", "ENTRY_SETTING", "", "K", "Ljava/lang/String;", "getTROOP_INTERACTIVE_IDENTIFICATION_URL", "()Ljava/lang/String;", "TROOP_INTERACTIVE_IDENTIFICATION_URL", "getURL_PARAM_MODE_COLOR", "URL_PARAM_MODE_COLOR", "M", "getURL_PARAM_SHOW_LUCKY_WORD", "URL_PARAM_SHOW_LUCKY_WORD", "N", "getURL_PARAM_WEB_VIEW", "URL_PARAM_WEB_VIEW", "P", "getURL_VALUE_DEFAULT_COLOR", "URL_VALUE_DEFAULT_COLOR", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getURL_VALUE_WEB_VIEW", "URL_VALUE_WEB_VIEW", "", "Z", "isShowLuckCharacter", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/widget/listitem/x;", "friendHudongConfig", "T", "groupHudongConfig", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PrivacyInterNewSetFragment extends BaseSettingFragment {

    /* renamed from: J, reason: from kotlin metadata */
    private final int ENTRY_SETTING = 1;

    /* renamed from: K, reason: from kotlin metadata */
    private final String TROOP_INTERACTIVE_IDENTIFICATION_URL = "https://qun.qq.com/interactive/usersetting";

    /* renamed from: L, reason: from kotlin metadata */
    private final String URL_PARAM_MODE_COLOR = "mode_color";

    /* renamed from: M, reason: from kotlin metadata */
    private final String URL_PARAM_SHOW_LUCKY_WORD = "showLuckyWord";

    /* renamed from: N, reason: from kotlin metadata */
    private final String URL_PARAM_WEB_VIEW = "_wv";

    /* renamed from: P, reason: from kotlin metadata */
    private final String URL_VALUE_DEFAULT_COLOR = "ffffff";

    /* renamed from: Q, reason: from kotlin metadata */
    private final String URL_VALUE_WEB_VIEW = "3";

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isShowLuckCharacter;

    /* renamed from: S, reason: from kotlin metadata */
    private x<x.b.d, x.c.g> friendHudongConfig;

    /* renamed from: T, reason: from kotlin metadata */
    private x<x.b.d, x.c.g> groupHudongConfig;

    private final void Dh() {
        boolean a16 = new com.tencent.mobileqq.troop.luckycharacter.config.a().a();
        this.isShowLuckCharacter = a16;
        x<x.b.d, x.c.g> xVar = null;
        if (a16) {
            x<x.b.d, x.c.g> xVar2 = this.groupHudongConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("groupHudongConfig");
            } else {
                xVar = xVar2;
            }
            x.b.d K = xVar.K();
            String string = getString(R.string.f2340678y);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.troop\u2026r_and_luckycharacter_str)");
            K.b(string);
            return;
        }
        x<x.b.d, x.c.g> xVar3 = this.groupHudongConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupHudongConfig");
        } else {
            xVar = xVar3;
        }
        x.b.d K2 = xVar.K();
        String string2 = getString(R.string.f173228xc1);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.troop_honor_setting)");
        K2.b(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(Intent troopIntent) {
        String str;
        Uri.Builder buildUpon = Uri.parse(this.TROOP_INTERACTIVE_IDENTIFICATION_URL).buildUpon();
        if (SimpleUIUtil.getSimpleUISwitch()) {
            int simpleUiBgColor = SimpleUIUtil.getSimpleUiBgColor();
            if (simpleUiBgColor != 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%08x", Arrays.copyOf(new Object[]{Integer.valueOf(simpleUiBgColor)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                String substring = format.substring(2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                buildUpon.appendQueryParameter(this.URL_PARAM_MODE_COLOR, substring);
            }
        } else {
            buildUpon.appendQueryParameter(this.URL_PARAM_MODE_COLOR, this.URL_VALUE_DEFAULT_COLOR);
        }
        String str2 = this.URL_PARAM_SHOW_LUCKY_WORD;
        if (this.isShowLuckCharacter) {
            str = "1";
        } else {
            str = "0";
        }
        buildUpon.appendQueryParameter(str2, str);
        buildUpon.appendQueryParameter(this.URL_PARAM_WEB_VIEW, this.URL_VALUE_WEB_VIEW);
        troopIntent.putExtra("url", buildUpon.toString());
    }

    private final <L extends x.b, R extends x.c> x<L, R> Jh(x<L, R> xVar, final Function0<Unit> function0) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.settings.fragment.t
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PrivacyInterNewSetFragment.Kh(Ref.BooleanRef.this, function0, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Ref.BooleanRef firstExpo, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(firstExpo, "$firstExpo");
        Intrinsics.checkNotNullParameter(it, "it");
        if (firstExpo.element) {
            firstExpo.element = false;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final x<x.b.d, x.c.g> Lh(CharSequence leftText, int leftIcon, CharSequence rightText, final Function0<Unit> onClick, final Function0<Unit> onExpo) {
        x.b dVar;
        if (leftIcon != 0) {
            dVar = new x.b.C8996b(leftText, leftIcon);
        } else {
            dVar = new x.b.d(leftText);
        }
        x<x.b.d, x.c.g> xVar = new x<>(dVar, new x.c.g(rightText, true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.fragment.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyInterNewSetFragment.Mh(Function0.this, view);
            }
        });
        Jh(xVar, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.fragment.PrivacyInterNewSetFragment$singleLineConfig$1$2
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
                Function0<Unit> function0 = onExpo;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        return xVar;
    }

    private final void initData() {
        if (getQBaseActivity() == null) {
            return;
        }
        AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        Manager manager = appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        x<x.b.d, x.c.g> xVar = null;
        if (!((FriendsManager) manager).q(appRuntime.getCurrentAccountUin()).allowCalInteractive) {
            x<x.b.d, x.c.g> xVar2 = this.friendHudongConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendHudongConfig");
                xVar2 = null;
            }
            x.c.g O = xVar2.O();
            String qqStr = HardCodeUtil.qqStr(R.string.f171523iz3);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_setting_privacy_enable)");
            O.h(qqStr);
        } else {
            x<x.b.d, x.c.g> xVar3 = this.friendHudongConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendHudongConfig");
                xVar3 = null;
            }
            x.c.g O2 = xVar3.O();
            String qqStr2 = HardCodeUtil.qqStr(R.string.iz4);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qq_setting_privacy_not_enable)");
            O2.h(qqStr2);
        }
        Dh();
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            x<x.b.d, x.c.g> xVar4 = this.friendHudongConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendHudongConfig");
                xVar4 = null;
            }
            th5.l0(xVar4);
        }
        QUIListItemAdapter th6 = th();
        if (th6 != null) {
            x<x.b.d, x.c.g> xVar5 = this.groupHudongConfig;
            if (xVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("groupHudongConfig");
            } else {
                xVar = xVar5;
            }
            th6.l0(xVar);
        }
    }

    /* renamed from: Gh, reason: from getter */
    public final int getENTRY_SETTING() {
        return this.ENTRY_SETTING;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = getString(R.string.f2046353f);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_se\u2026y_permission_interaction)");
        setTitle(string);
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] Eh = Eh();
            th5.t0((Group[]) Arrays.copyOf(Eh, Eh.length));
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Fh() {
        String string;
        ReportController.o(null, "dc00898", "", "", "0X800B7F0", "0X800B7F0", 0, 0, "", "", "", "");
        final AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        Intrinsics.checkNotNullExpressionValue(getString(R.string.aya), "getString(com.tencent.qq\u2026eqlock_auth_already_open)");
        if (com.tencent.qqnt.qbasealbum.utils.a.f361642a.a() == 1) {
            string = getString(R.string.aya);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.qq\u2026eqlock_auth_already_open)");
        } else {
            string = getString(R.string.ayo);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.qq\u2026ing.eqlock_close_success)");
        }
        String string2 = getString(R.string.f170651xh);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.cal_interactive_days)");
        x<x.b.d, x.c.g> Lh = Lh(string2, 0, string, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.fragment.PrivacyInterNewSetFragment$friendHudongSettingMsgConfig$friendConfig$1
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
                ReportController.o(AppRuntime.this, "CliOper", "", "", "0X800B854", "0X800B854", 0, 0, "", "", "", "");
                com.tencent.mobileqq.mutualmark.g.p((QQAppInterface) AppRuntime.this, this.getQBaseActivity(), this.getENTRY_SETTING());
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.fragment.PrivacyInterNewSetFragment$friendHudongSettingMsgConfig$friendConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        this.friendHudongConfig = Lh;
        return Lh;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Ih() {
        ReportController.o(null, "dc00898", "", "", "0X800B7F1", "0X800B7F1", 0, 0, "", "", "", "");
        String string = getString(R.string.f2340678y);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.troop\u2026r_and_luckycharacter_str)");
        x<x.b.d, x.c.g> Lh = Lh(string, 0, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.fragment.PrivacyInterNewSetFragment$groupHudongSettingMsgConfig$groupConfig$1
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
                ReportController.o(null, "dc00898", "", "", "0X800B855", "0X800B855", 0, 0, "", "0", "0", "");
                Intent intent = new Intent(PrivacyInterNewSetFragment.this.getQBaseActivity(), (Class<?>) QQBrowserActivity.class);
                PrivacyInterNewSetFragment.this.Hh(intent);
                PrivacyInterNewSetFragment.this.startActivity(intent);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.settings.fragment.PrivacyInterNewSetFragment$groupHudongSettingMsgConfig$groupConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        this.groupHudongConfig = Lh;
        return Lh;
    }

    public final Group[] Eh() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Fh(), Ih());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }
}

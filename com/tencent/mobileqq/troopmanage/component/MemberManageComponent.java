package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerComponentApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troopmanage.activity.SetTroopAdminsActivity;
import com.tencent.mobileqq.troopmanage.event.TroopManageAdminListEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B/\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J*\u0010\u000f\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J*\u0010\u0010\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J$\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/MemberManageComponent;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Landroid/view/View$OnClickListener;", "N", "L", "J", "", "", "P", "troopAdminList", "Lvt2/a;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", DownloadInfo.spKey_Config, "", "T", UserInfo.SEX_FEMALE, "", "adminSize", "G", "Lcom/tencent/mobileqq/widget/listitem/Group;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "g", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MemberManageComponent extends bv {

    /* renamed from: h, reason: collision with root package name */
    private static int f303052h;

    static {
        f303052h = SimpleUIUtil.isNowElderMode() ? 2 : 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberManageComponent(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    private final void F(List<String> troopAdminList, vt2.a<x.b.d, x.c.g> config) {
        String format;
        if (troopAdminList.isEmpty()) {
            format = b().getString(R.string.z8w);
        } else {
            String string = b().getString(R.string.z8v);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026_manage_set_admin_member)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(troopAdminList.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        Intrinsics.checkNotNullExpressionValue(format, "if (troopAdminList.isEmp\u2026AdminList.size)\n        }");
        LinearLayout mFaceBoxLayout = config.getMFaceBoxLayout();
        if (mFaceBoxLayout != null) {
            TextView textView = new TextView(b());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.dap));
            textView.setTextColor(ContextCompat.getColor(b(), R.color.qui_common_text_secondary));
            textView.setText(format);
            mFaceBoxLayout.addView(textView);
        }
    }

    private final void G(vt2.a<x.b.d, x.c.g> config, final int adminSize) {
        ImageView imageView = new ImageView(b().getBaseContext());
        int b16 = UIUtils.b(b(), SimpleUIUtil.isNowElderMode() ? 30.0f : 32.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b16, b16);
        layoutParams.leftMargin = UIUtils.b(b(), SimpleUIUtil.isNowElderMode() ? 4.0f : 8.0f);
        imageView.setImageDrawable(b().getResources().getDrawable(R.drawable.lwq));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberManageComponent.H(MemberManageComponent.this, adminSize, view);
            }
        });
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troopmanage.component.at
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean I;
                I = MemberManageComponent.I(view, motionEvent);
                return I;
            }
        });
        imageView.setContentDescription(b().getString(R.string.z8s));
        LinearLayout mFaceBoxLayout = config.getMFaceBoxLayout();
        if (mFaceBoxLayout != null) {
            mFaceBoxLayout.addView(imageView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(MemberManageComponent this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int max = Math.max(this$0.g().h().maxAdminNum, 10);
        if (i3 >= max) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this$0.b().getString(R.string.i4u);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026troop_admin_overload_tip)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(max)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QQToast.makeText(this$0.b(), 1, format, 0).show(this$0.b().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        Intent troopMemberListActivityLaunchIntent = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMemberListActivityLaunchIntent(this$0.b(), this$0.g().j(), 2);
        troopMemberListActivityLaunchIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        this$0.b().startActivityForResult(troopMemberListActivityLaunchIntent, 32);
    }

    private final View.OnClickListener J() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberManageComponent.K(MemberManageComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(MemberManageComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String j3 = this$0.g().j();
        Intent intent = new Intent();
        intent.putExtra("troop_uin", j3);
        ((ITroopManagerComponentApi) QRoute.api(ITroopManagerComponentApi.class)).startTroopBlackListFragment(this$0.b(), intent);
        bv.l(this$0, "em_group_blacklist_manage", null, 2, null);
    }

    private final View.OnClickListener L() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.av
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberManageComponent.M(MemberManageComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(MemberManageComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.b(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this$0.h().S1());
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, this$0.b().getString(R.string.i7o));
        intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        this$0.b().startActivity(intent);
        bv.l(this$0, "em_group_members_act_data", null, 2, null);
    }

    private final View.OnClickListener N() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.aw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberManageComponent.O(MemberManageComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(MemberManageComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, this$0.b().getString(R.string.i7o));
        String j3 = this$0.g().j();
        String str = this$0.g().h().troopcode;
        int p16 = this$0.h().X1().p();
        QLog.d("MemberManageComponent", 1, "[onClick] troopUin:" + j3 + ", troopCode:" + str + ", maxNum:" + p16);
        intent.putExtra("troop_uin", j3);
        intent.putExtra(AppConstants.Key.TROOP_CODE, str);
        intent.putExtra("maxAdminNum", p16);
        intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        QPublicFragmentActivity.startForResult(this$0.b(), intent, (Class<? extends QPublicBaseFragment>) SetTroopAdminsActivity.class, 2);
        bv.l(this$0, "em_group_set_admin", null, 2, null);
    }

    private final List<String> P() {
        List emptyList;
        ArrayList arrayList = new ArrayList();
        String administrator = g().h().Administrator;
        if (TextUtils.isEmpty(administrator)) {
            return arrayList;
        }
        Intrinsics.checkNotNullExpressionValue(administrator, "administrator");
        List<String> split = new Regex("\\|").split(administrator, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (String str : (String[]) array) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(MemberManageComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_members_act_data", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(List<String> troopAdminList, vt2.a<x.b.d, x.c.g> config) {
        if (b().isFinishing()) {
            return;
        }
        LinearLayout mFaceBoxLayout = config.getMFaceBoxLayout();
        if (mFaceBoxLayout != null) {
            mFaceBoxLayout.removeAllViews();
        }
        F(troopAdminList, config);
        for (int i3 = 0; i3 < troopAdminList.size() && i3 < f303052h; i3++) {
            String str = troopAdminList.get(i3);
            QQProAvatarView qQProAvatarView = new QQProAvatarView(b(), (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            int b16 = UIUtils.b(b(), SimpleUIUtil.isNowElderMode() ? 30.0f : 32.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(b16, b16);
            layoutParams.leftMargin = UIUtils.b(b(), SimpleUIUtil.isNowElderMode() ? 4.0f : 8.0f);
            if (TextUtils.isEmpty(str)) {
                qQProAvatarView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
            } else {
                qQProAvatarView.x(1, str, null);
            }
            qQProAvatarView.setTag(str);
            LinearLayout mFaceBoxLayout2 = config.getMFaceBoxLayout();
            if (mFaceBoxLayout2 != null) {
                mFaceBoxLayout2.addView(qQProAvatarView, layoutParams);
            }
        }
        G(config, troopAdminList.size());
    }

    public Group Q() {
        String string = b().getString(R.string.z8u);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026_member_manage_set_admin)");
        final vt2.a<x.b.d, x.c.g> aVar = new vt2.a<>(new x.b.d(string), new x.c.g("", false, false, 6, null), Integer.valueOf(b().getResources().getDimensionPixelSize(R.dimen.f158569j8)));
        bv.n(this, "em_group_set_admin", null, 2, null);
        aVar.x(N());
        T(P(), aVar);
        MutableLiveData<TroopManageAdminListEvent> U1 = h().U1();
        LifecycleOwner e16 = e();
        final Function1<TroopManageAdminListEvent, Unit> function1 = new Function1<TroopManageAdminListEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.MemberManageComponent$getComponentGroup$addAdminConfig$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageAdminListEvent troopManageAdminListEvent) {
                invoke2(troopManageAdminListEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageAdminListEvent troopManageAdminListEvent) {
                MemberManageComponent.this.T(troopManageAdminListEvent.getTroopAdminList(), aVar);
                MemberManageComponent.this.c().l0(aVar);
            }
        };
        U1.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MemberManageComponent.R(Function1.this, obj);
            }
        });
        if (i()) {
            h().X1().j(e(), "MemberManageComponent");
        }
        com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.z8t, "", null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.ar
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                MemberManageComponent.S(MemberManageComponent.this, view);
            }
        });
        v3.p((g().e() || TextUtils.isEmpty(h().S1())) ? false : true);
        v3.x(L());
        com.tencent.mobileqq.widget.listitem.x v16 = bv.v(this, R.string.f2325374t, "", null, null, 12, null);
        v16.p(((ITroopManagerComponentApi) QRoute.api(ITroopManagerComponentApi.class)).isTroopBlackListEnable());
        v16.x(J());
        ArrayList arrayList = new ArrayList();
        if (i()) {
            arrayList.add(aVar);
        }
        arrayList.add(v3);
        arrayList.add(v16);
        if (g().i().bOwner) {
            arrayList.addAll(new cb(b(), c(), e(), h(), d()).y().a());
        }
        String string2 = b().getString(R.string.z8r);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str\u2026ity_manage_member_manage)");
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group(string2, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(View view, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        view.setAlpha(motionEvent.getAction() == 0 ? 0.5f : 1.0f);
        return false;
    }
}

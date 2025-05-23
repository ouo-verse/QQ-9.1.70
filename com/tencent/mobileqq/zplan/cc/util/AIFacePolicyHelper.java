package com.tencent.mobileqq.zplan.cc.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.zplan.cc.view.AIFacePolicyDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/AIFacePolicyHelper;", "", "Landroid/content/Context;", "context", "", "targetId", "contentId", "Lkotlin/Function0;", "", "action", "Landroid/text/SpannableString;", "b", "Landroidx/fragment/app/Fragment;", "fragment", "c", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AIFacePolicyHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final AIFacePolicyHelper f332552a = new AIFacePolicyHelper();

    AIFacePolicyHelper() {
    }

    private final SpannableString b(Context context, int targetId, int contentId, Function0<Unit> action) {
        int indexOf$default;
        String string = context.getString(targetId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(targetId)");
        String string2 = context.getString(contentId);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(contentId)");
        SpannableString spannableString = new SpannableString(string2);
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string2, string, 0, false, 6, (Object) null);
        int length = string.length() + indexOf$default;
        n nVar = new n();
        nVar.a(action);
        spannableString.setSpan(nVar, indexOf$default, length, 17);
        return spannableString;
    }

    public final SpannableString a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return b(context, R.string.f203134zd, R.string.xpx, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.cc.util.AIFacePolicyHelper$getPolicyDialogSpannable$1
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
                context.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(AppConstants.URL.PRIVATE_PROTOCOL)));
            }
        });
    }

    public final SpannableString c(final Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        return b(requireContext, R.string.f169811xq3, R.string.f169808xq0, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.cc.util.AIFacePolicyHelper$getPolicyTipSpannable$1
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
                new AIFacePolicyDialog().show(Fragment.this.getChildFragmentManager(), "AIFacePolicyDialog");
            }
        });
    }
}

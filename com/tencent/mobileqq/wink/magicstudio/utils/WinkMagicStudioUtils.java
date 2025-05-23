package com.tencent.mobileqq.wink.magicstudio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioFragment;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment;
import com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioBaseFragment;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonReq;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioFragment;
import com.tencent.mobileqq.wink.request.QQWinkAIGCDoActionReq;
import com.tencent.mobileqq.wink.schema.d;
import com.tencent.mobileqq.wink.view.al;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$DoActionReply;
import qshadow.ShadowAIGCStatus$DoActionRequest;
import qshadow.ShadowAIGCStatus$GetStatusReply;
import tl.h;
import w93.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ@\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014J\"\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\u0019J\"\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u0019J\"\u0010&\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$J\u0010\u0010(\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u000bJ0\u0010.\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010,J \u00102\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u00010\u00102\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020$\u0018\u000100J\u0018\u00104\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u00103\u001a\u00020$J\u0010\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000105J\u001a\u00108\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010$\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/utils/WinkMagicStudioUtils;", "", "", "g", "", "r", "Landroid/content/Intent;", "intent", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/wink/magicstudio/WinkMagicStudioBaseFragment;", "f", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "buttonInfo", "j", "Landroid/content/Context;", "context", "", "privacyTitle", "privacyContent", "privacyUrl", "Lkotlin/Function0;", "positiveCallBack", "p", "", "scene", "Lkotlin/Function1;", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "respCallback", "o", "action", "Lqshadow/ShadowAIGCStatus$DoActionReply;", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioPicStyle", "k", "agiButtonInfo", "i", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "magicStyleMaterial", "buttonInfoResp", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategory", h.F, "defaultSelectionStyleId", "", "picStyleList", "d", "picStyle", "e", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "l", "c", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMagicStudioUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkMagicStudioUtils f323888a = new WinkMagicStudioUtils();

    WinkMagicStudioUtils() {
    }

    private final boolean g() {
        return AECameraPrefsUtil.c().b(r93.h.f430993a.f(), false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            try {
                fragmentManager.popBackStack();
            } catch (Throwable th5) {
                w53.b.e("WinkMagicStudioUtils", th5);
            }
        }
    }

    public static /* synthetic */ void q(WinkMagicStudioUtils winkMagicStudioUtils, Context context, String str, String str2, String str3, Function0 function0, int i3, Object obj) {
        String str4;
        String str5;
        String str6;
        if ((i3 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        if ((i3 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i3 & 8) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        winkMagicStudioUtils.p(context, str4, str5, str6, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        AECameraPrefsUtil.c().h(r93.h.f430993a.f(), true, 0);
    }

    public final void c(@Nullable Activity activity, @Nullable MagicStudioPicStyle magicStudioPicStyle) {
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag("AIGC_LOGIC");
            if (findFragmentByTag != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("magic_studio_pic_style", magicStudioPicStyle);
                if (WinkMagicStudioLogicUtils.f323883a.h()) {
                    MagicStudioLogicFragment.INSTANCE.c(activity, findFragmentByTag, bundle);
                }
            }
            l(fragmentActivity.getSupportFragmentManager());
        }
    }

    public final int d(@Nullable String defaultSelectionStyleId, @Nullable List<MagicStudioPicStyle> picStyleList) {
        Object firstOrNull;
        Integer num;
        if (picStyleList == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : picStyleList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((MagicStudioPicStyle) obj).getStyleId(), defaultSelectionStyleId)) {
                num = Integer.valueOf(i3);
            } else {
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
            i3 = i16;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        Integer num2 = (Integer) firstOrNull;
        if (num2 == null) {
            return 0;
        }
        return num2.intValue();
    }

    @NotNull
    public final String e(@Nullable MagicStudioButtonInfo agiButtonInfo, @NotNull MagicStudioPicStyle picStyle) {
        String str;
        Intrinsics.checkNotNullParameter(picStyle, "picStyle");
        String str2 = null;
        if (agiButtonInfo != null) {
            str = agiButtonInfo.getBtnString();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (agiButtonInfo != null) {
                str2 = agiButtonInfo.getBtnString();
            }
        } else if (!TextUtils.isEmpty(picStyle.getMakeButtonTitle())) {
            str2 = picStyle.getMakeButtonTitle();
        }
        if (str2 == null) {
            String qqStr = HardCodeUtil.qqStr(R.string.f240837q9);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(\n            R.str\u2026io_next_default\n        )");
            return qqStr;
        }
        return str2;
    }

    @NotNull
    public final Class<? extends WinkMagicStudioBaseFragment> f(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!r93.h.f430993a.g() || Intrinsics.areEqual(d.f326305a.k("second_target", intent), "0")) {
            return MagicStudioFragment.class;
        }
        return WinkQZoneMagicStudioFragment.class;
    }

    public final void h(@NotNull Activity activity, @NotNull Fragment fragment, @NotNull MetaMaterial magicStyleMaterial, @NotNull ShadowAIGCStatus$GetStatusReply buttonInfoResp, @Nullable MetaCategory metaCategory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(magicStyleMaterial, "magicStyleMaterial");
        Intrinsics.checkNotNullParameter(buttonInfoResp, "buttonInfoResp");
        MagicStudioButtonInfo a16 = MagicStudioButtonInfo.INSTANCE.a(buttonInfoResp);
        WinkMagicStudioLogicUtils.o(WinkMagicStudioLogicUtils.f323883a, activity, fragment, MagicStudioPicStyle.INSTANCE.a(magicStyleMaterial, metaCategory), a16, metaCategory, null, null, null, 224, null);
    }

    public final boolean i(@Nullable MagicStudioButtonInfo agiButtonInfo) {
        boolean z16 = false;
        if (agiButtonInfo != null && agiButtonInfo.getActionType() == 4) {
            z16 = true;
        }
        return !z16;
    }

    public final boolean j(@Nullable MagicStudioButtonInfo buttonInfo) {
        boolean z16;
        if (g()) {
            return false;
        }
        if (buttonInfo != null && buttonInfo.getActionType() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public final void k(@Nullable Activity activity, @NotNull Fragment fragment, @Nullable MagicStudioPicStyle magicStudioPicStyle) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (activity != null && magicStudioPicStyle != null) {
            MagicStudioLogicFragment.Companion companion = MagicStudioLogicFragment.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putSerializable("magic_studio_pic_style", magicStudioPicStyle);
            Unit unit = Unit.INSTANCE;
            companion.c(activity, fragment, bundle);
        }
    }

    public final void l(@Nullable final FragmentManager fragmentManager) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                WinkMagicStudioUtils.m(FragmentManager.this);
            }
        }, 300L);
    }

    public final void n(int action, @NotNull final Function1<? super ShadowAIGCStatus$DoActionReply, Unit> respCallback) {
        Intrinsics.checkNotNullParameter(respCallback, "respCallback");
        ShadowAIGCStatus$DoActionRequest shadowAIGCStatus$DoActionRequest = new ShadowAIGCStatus$DoActionRequest();
        shadowAIGCStatus$DoActionRequest.busi_id.set("qzone_magic_studio");
        shadowAIGCStatus$DoActionRequest.action.set(action);
        e.f445096a.j(new QQWinkAIGCDoActionReq(shadowAIGCStatus$DoActionRequest), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCStatus$DoActionReply, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils$requestMagicStudioButtonDoAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str, ShadowAIGCStatus$DoActionReply shadowAIGCStatus$DoActionReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str, shadowAIGCStatus$DoActionReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j3, @Nullable String str, @Nullable ShadowAIGCStatus$DoActionReply shadowAIGCStatus$DoActionReply) {
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowAIGCStatus$DoActionReply != null && j3 == 0 && z16) {
                    respCallback.invoke(shadowAIGCStatus$DoActionReply);
                } else {
                    MagicStudioDataSource.f323652a.l0(j3, str);
                }
            }
        });
    }

    public final void o(int scene, @NotNull final Function1<? super ShadowAIGCStatus$GetStatusReply, Unit> respCallback) {
        Intrinsics.checkNotNullParameter(respCallback, "respCallback");
        e.f445096a.j(new MagicStudioButtonReq(scene), new Function5<BaseRequest, Boolean, Long, String, ShadowAIGCStatus$GetStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils$requestMagicStudioButtonInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str, ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str, shadowAIGCStatus$GetStatusReply);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j3, @Nullable String str, @Nullable ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowAIGCStatus$GetStatusReply != null && j3 == 0 && z16) {
                    w53.b.f("WinkMagicStudioUtils", "requestMagicStudioButtonInfo retCode: " + j3);
                    respCallback.invoke(shadowAIGCStatus$GetStatusReply);
                    return;
                }
                MagicStudioDataSource.f323652a.l0(j3, str);
            }
        });
    }

    public final void p(@NotNull Context context, @Nullable String privacyTitle, @Nullable String privacyContent, @Nullable String privacyUrl, @NotNull final Function0<Unit> positiveCallBack) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(positiveCallBack, "positiveCallBack");
        if (privacyTitle == null) {
            privacyTitle = HardCodeUtil.qqStr(R.string.f240057o5);
        }
        String dialogPrivacyTitle = privacyTitle;
        if (privacyContent == null) {
            privacyContent = HardCodeUtil.qqStr(R.string.f240047o4);
        }
        String dialogPrivacyContent = privacyContent;
        if (TextUtils.isEmpty(privacyUrl)) {
            if (r93.h.f430993a.g()) {
                privacyUrl = "https://rule.tencent.com/rule/202312070001";
            } else {
                privacyUrl = "https://rule.tencent.com/rule/202312250004";
            }
        } else {
            Intrinsics.checkNotNull(privacyUrl);
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils$showPrivacyProtoDialog$dialog$1
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
                WinkMagicStudioUtils.f323888a.r();
                positiveCallBack.invoke();
            }
        };
        WinkMagicStudioUtils$showPrivacyProtoDialog$dialog$2 winkMagicStudioUtils$showPrivacyProtoDialog$dialog$2 = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils$showPrivacyProtoDialog$dialog$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullExpressionValue(dialogPrivacyContent, "dialogPrivacyContent");
        Intrinsics.checkNotNullExpressionValue(dialogPrivacyTitle, "dialogPrivacyTitle");
        new al(context, function0, winkMagicStudioUtils$showPrivacyProtoDialog$dialog$2, privacyUrl, dialogPrivacyContent, dialogPrivacyTitle).show();
    }
}

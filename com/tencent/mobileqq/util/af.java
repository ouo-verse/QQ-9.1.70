package com.tencent.mobileqq.util;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004H\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000e\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/util/af;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/app/FrameFragment$e;", "Lkotlin/collections/ArrayList;", "tabSpecList", "", "e", "", "i", "a", "d", "", "f", "g", "c", "b", "", tl.h.F, "Ljava/lang/Boolean;", "isSupportTabLayout", "<init>", "()V", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final af f306546a = new af();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean isSupportTabLayout;

    af() {
    }

    @JvmStatic
    public static final boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("enable_newest_pre_frame_9085_127997014", true);
    }

    @JvmStatic
    public static final int b() {
        if (d()) {
            return R.id.f919256h;
        }
        return android.R.id.tabcontent;
    }

    @JvmStatic
    public static final int c() {
        if (d()) {
            return R.id.f9174560;
        }
        return android.R.id.tabhost;
    }

    @JvmStatic
    public static final boolean d() {
        f306546a.h();
        Boolean bool = isSupportTabLayout;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull ArrayList<FrameFragment.e> tabSpecList) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(tabSpecList, "tabSpecList");
        StringBuilder sb5 = new StringBuilder();
        Iterator<FrameFragment.e> it = tabSpecList.iterator();
        while (it.hasNext()) {
            FrameFragment.e next = it.next();
            if (next == null) {
                sb5.append("null");
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(TokenParser.SP);
                String tag = next.getTag();
                Intrinsics.checkNotNullExpressionValue(tag, "tabSpec.tag");
                String tag2 = next.getTag();
                Intrinsics.checkNotNullExpressionValue(tag2, "tabSpec.tag");
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) tag2, '.', 0, false, 6, (Object) null);
                String substring = tag.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                sb6.append(substring);
                sb5.append(sb6.toString());
            }
        }
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
        return sb7;
    }

    @JvmStatic
    public static final int f() {
        if (d()) {
            return R.id.f917355z;
        }
        return android.R.id.tabs;
    }

    @JvmStatic
    public static final int g() {
        if (d()) {
            return R.id.f917355z;
        }
        return android.R.id.tabhost;
    }

    private final void h() {
        if (isSupportTabLayout == null) {
            boolean z16 = false;
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tab_layout_9065_116522266", false);
            if (isSwitchOn && !AppSetting.t(BaseApplication.getContext())) {
                z16 = true;
            }
            isSupportTabLayout = Boolean.valueOf(z16);
            QLog.d("FrameUtil.", 1, "initTabLayoutSwitch : " + isSupportTabLayout + ", serverSwitch : " + isSwitchOn);
        }
    }

    @JvmStatic
    public static final boolean i() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tab_part_9060_116522266", true);
    }
}

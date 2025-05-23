package com.tencent.mobileqq.exportfile.fragment.filelist;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\t\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u000026\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\n\u0010\u000b\u001a\u00020\u0003*\u00020\n\u00a8\u0006\f"}, d2 = {"", "size", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "numberString", "unitString", "formatter", "b", "Landroidx/fragment/app/Fragment;", "a", "wifiphoto_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class t {
    @NotNull
    public static final String a(@NotNull Fragment fragment) {
        String str;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            str = "\u6211";
        } else {
            IQQRelationNameService iQQRelationNameService = (IQQRelationNameService) QRoute.api(IQQRelationNameService.class);
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            String currentUid = peekAppRuntime.getCurrentUid();
            Intrinsics.checkNotNullExpressionValue(currentUid, "app.currentUid");
            aVar.d(currentUid);
            str = iQQRelationNameService.nameWithConfig(aVar) + " ";
        }
        String string = BaseApplication.context.getString(R.string.zwh, str);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ort_file_list_title, who)");
        return string;
    }

    @NotNull
    public static final String b(long j3, @NotNull Function2<? super String, ? super String, String> formatter) {
        String valueOf;
        String str;
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        float f16 = (float) j3;
        float f17 = f16 / 1.07374182E9f;
        if (f17 > 1.0f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            valueOf = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f17)}, 1));
            Intrinsics.checkNotNullExpressionValue(valueOf, "format(format, *args)");
            str = "GB";
        } else {
            float f18 = f16 / 1048576.0f;
            if (f18 > 1.0f) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                valueOf = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f18)}, 1));
                Intrinsics.checkNotNullExpressionValue(valueOf, "format(format, *args)");
                str = "MB";
            } else {
                float f19 = f16 / 1024.0f;
                if (f19 > 1.0f) {
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    valueOf = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f19)}, 1));
                    Intrinsics.checkNotNullExpressionValue(valueOf, "format(format, *args)");
                    str = "KB";
                } else {
                    if (j3 <= 0) {
                        valueOf = "0";
                    } else {
                        valueOf = String.valueOf(j3);
                    }
                    str = "B";
                }
            }
        }
        return formatter.invoke(valueOf, str);
    }
}

package com.tencent.libra.cache;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.business.Monitor;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017J\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/libra/cache/c;", "", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/cache/api/Business;", "getBusiness", "Lcom/tencent/cache/api/PageHierarchy;", "getSubBusiness", "", "Lcom/tencent/cache/api/d;", "getPageArgus", "rfw-picloader-extension-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class a {
        public static final /* synthetic */ Set a(c cVar, Option option) {
            return b(cVar, option);
        }

        public static Set<com.tencent.cache.api.d> b(c cVar, Option option) {
            if (option != null && option.getTargetView() != null) {
                try {
                    Fragment findFragment = FragmentManager.findFragment(option.getTargetView());
                    Intrinsics.checkNotNullExpressionValue(findFragment, "findFragment<Fragment>(option.targetView)");
                    Monitor monitor = Monitor.INSTANCE;
                    String name = findFragment.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "targetFragment.javaClass.name");
                    return monitor.getPageArgusByFragment(name);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BusinessTagProvider", 1, "getPageArgus error, seq = " + option.getSeq() + ", " + e16.getMessage());
                    }
                }
            }
            return null;
        }
    }

    @JvmDefault
    @NotNull
    Business getBusiness(@Nullable Option option);

    @JvmDefault
    @Nullable
    PageHierarchy getSubBusiness(@Nullable Option option);
}

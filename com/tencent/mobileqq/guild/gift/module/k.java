package com.tencent.mobileqq.guild.gift.module;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/module/k;", "T", "", "", "errCode", "", "errMsg", "", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "", "isFromPack", HippyTKDListViewAdapter.X, "originalData", "I", "(Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface k<T> {
    void I(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, T originalData);

    void o();

    void s(int errCode, @Nullable String errMsg);

    void x(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, boolean isFromPack);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static <T> void a(@NotNull k<T> kVar) {
        }

        public static <T> void b(@NotNull k<T> kVar, int i3, @Nullable String str) {
        }
    }
}

package com.tencent.mobileqq.zplan.utils;

import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/ax;", "", "", "a", "b", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ax {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ax f335802a = new ax();

    ax() {
    }

    public final int a() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            return com.tencent.mobileqq.pad.m.d();
        }
        return ViewUtils.getScreenWidth();
    }

    public final int b() {
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        if (PadUtil.a(BaseApplication.getContext()) != DeviceType.FOLD) {
            return i3;
        }
        return i3 - com.tencent.mobileqq.pad.m.d();
    }
}

package com.tencent.mobileqq.onlinestatus.utils;

import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "", "b", "<init>", "()V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f256332a = new a();

    a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void a(@Nullable QBaseActivity activity) {
        com.tencent.mobileqq.onlinestatus.y yVar;
        if (OnlineStatusToggleUtils.e() && activity != null) {
            try {
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(com.tencent.mobileqq.onlinestatus.y.class.getName());
                if (findFragmentByTag != 0) {
                    if (findFragmentByTag instanceof com.tencent.mobileqq.onlinestatus.y) {
                        yVar = (com.tencent.mobileqq.onlinestatus.y) findFragmentByTag;
                    } else {
                        yVar = null;
                    }
                    if (yVar != null) {
                        yVar.s8();
                    }
                    supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                    findFragmentByTag.onDetach();
                }
            } catch (Exception e16) {
                QLog.e(com.tencent.mobileqq.onlinestatus.y.class.getName(), 1, "closeAccountPanel " + e16);
            }
        }
    }

    @JvmStatic
    public static final boolean b(@Nullable QBaseActivity activity) {
        com.tencent.mobileqq.onlinestatus.y yVar;
        if (OnlineStatusToggleUtils.e() && activity != null) {
            try {
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                ActivityResultCaller findFragmentByTag = supportFragmentManager.findFragmentByTag(com.tencent.mobileqq.onlinestatus.y.class.getName());
                if (findFragmentByTag instanceof com.tencent.mobileqq.onlinestatus.y) {
                    yVar = (com.tencent.mobileqq.onlinestatus.y) findFragmentByTag;
                } else {
                    yVar = null;
                }
                if (yVar == null) {
                    return false;
                }
                if (!yVar.isShowing()) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                QLog.w(com.tencent.mobileqq.onlinestatus.y.class.getName(), 1, "closeAccountPanel " + e16);
            }
        }
        return false;
    }
}

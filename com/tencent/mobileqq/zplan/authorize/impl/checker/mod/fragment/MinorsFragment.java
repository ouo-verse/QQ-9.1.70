package com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lc3.b;
import mc3.InsExeExtParam;
import mqq.app.Constants;
import qv4.av;
import qv4.j;
import xu4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/fragment/MinorsFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MinorsFragment extends QPublicBaseFragment {
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle savedInstanceState) {
        String str;
        a[] aVarArr;
        FragmentActivity activity;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        byte[] byteArray = arguments != null ? arguments.getByteArray("mod_login_rsp") : null;
        Bundle arguments2 = getArguments();
        byte[] byteArray2 = arguments2 != null ? arguments2.getByteArray("enter_mod_rsp") : null;
        Bundle arguments3 = getArguments();
        Integer valueOf = arguments3 != null ? Integer.valueOf(arguments3.getInt(VRReportDefine$ReportParam.AD_MOD_ID)) : null;
        Bundle arguments4 = getArguments();
        String string = arguments4 != null ? arguments4.getString("open_id") : null;
        Bundle arguments5 = getArguments();
        String string2 = arguments5 != null ? arguments5.getString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN) : null;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getArguments());
        if (byteArray == null || valueOf == null || string == null || string2 == null || f16 == null) {
            QLog.e("Checker_MinorsFragment", 1, "arguments error");
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
        if (byteArray2 != null) {
            if (true ^ (byteArray2.length == 0)) {
                j c16 = j.c(byteArray2);
                str = c16.f430172f;
                Intrinsics.checkNotNullExpressionValue(str, "enterModRsp.traceid");
                aVarArr = c16.f430171e;
                a[] aVarArr2 = aVarArr;
                b bVar = new b() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$opt$1
                    @Override // lc3.b
                    public void a(int mapId, long exitCode, String msg2) {
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        QLog.i("Checker_MinorsFragment", 1, "exitGame: mapId=" + mapId);
                        final MinorsFragment minorsFragment = MinorsFragment.this;
                        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$opt$1$exitGame$1
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
                                FragmentActivity activity3 = MinorsFragment.this.getActivity();
                                if (activity3 != null) {
                                    activity3.finish();
                                }
                                FragmentActivity activity4 = MinorsFragment.this.getActivity();
                                if (activity4 != null) {
                                    activity4.overridePendingTransition(0, 0);
                                }
                            }
                        });
                    }
                };
                lc3.a aVar = new lc3.a() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$notifier$1
                    @Override // lc3.a
                    public void d(long from, int mapId, String url) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        QLog.e("Checker_MinorsFragment", 1, "onMinorsJumpToUrl: mapId=" + mapId + ", from=" + from);
                        final MinorsFragment minorsFragment = MinorsFragment.this;
                        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$notifier$1$onJumpToUrl$1
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
                                FragmentActivity activity3 = MinorsFragment.this.getActivity();
                                if (activity3 != null) {
                                    activity3.finish();
                                }
                                FragmentActivity activity4 = MinorsFragment.this.getActivity();
                                if (activity4 != null) {
                                    activity4.overridePendingTransition(0, 0);
                                }
                            }
                        });
                    }

                    @Override // lc3.a
                    public void e(int mapId, long exitCode, String msg2) {
                        QLog.e("Checker_MinorsFragment", 1, "onMinorsLoginInterrupt: mapId=" + mapId + ", exitCode=" + exitCode + ", msg=" + msg2);
                        final MinorsFragment minorsFragment = MinorsFragment.this;
                        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$notifier$1$onLoginInterrupt$1
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
                                FragmentActivity activity3 = MinorsFragment.this.getActivity();
                                if (activity3 != null) {
                                    activity3.finish();
                                }
                                FragmentActivity activity4 = MinorsFragment.this.getActivity();
                                if (activity4 != null) {
                                    activity4.overridePendingTransition(0, 0);
                                }
                            }
                        });
                    }
                };
                activity = getActivity();
                if (activity == null) {
                    Intrinsics.checkNotNull(valueOf);
                    int intValue = valueOf.intValue();
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    Intrinsics.checkNotNull(f16);
                    oc3.b.f422445a.a(1L, new InsExeExtParam(str), new GameJudgeParams(intValue, string, string2, bVar, aVar, companion.j(f16.getFrom()), activity), aVarArr2);
                    return;
                }
                return;
            }
        }
        av c17 = av.c(byteArray);
        str = c17.f430020f;
        Intrinsics.checkNotNullExpressionValue(str, "modLoginRsp.traceid");
        aVarArr = c17.f430017c;
        a[] aVarArr22 = aVarArr;
        b bVar2 = new b() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$opt$1
            @Override // lc3.b
            public void a(int mapId, long exitCode, String msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                QLog.i("Checker_MinorsFragment", 1, "exitGame: mapId=" + mapId);
                final MinorsFragment minorsFragment = MinorsFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$opt$1$exitGame$1
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
                        FragmentActivity activity3 = MinorsFragment.this.getActivity();
                        if (activity3 != null) {
                            activity3.finish();
                        }
                        FragmentActivity activity4 = MinorsFragment.this.getActivity();
                        if (activity4 != null) {
                            activity4.overridePendingTransition(0, 0);
                        }
                    }
                });
            }
        };
        lc3.a aVar2 = new lc3.a() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$notifier$1
            @Override // lc3.a
            public void d(long from, int mapId, String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                QLog.e("Checker_MinorsFragment", 1, "onMinorsJumpToUrl: mapId=" + mapId + ", from=" + from);
                final MinorsFragment minorsFragment = MinorsFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$notifier$1$onJumpToUrl$1
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
                        FragmentActivity activity3 = MinorsFragment.this.getActivity();
                        if (activity3 != null) {
                            activity3.finish();
                        }
                        FragmentActivity activity4 = MinorsFragment.this.getActivity();
                        if (activity4 != null) {
                            activity4.overridePendingTransition(0, 0);
                        }
                    }
                });
            }

            @Override // lc3.a
            public void e(int mapId, long exitCode, String msg2) {
                QLog.e("Checker_MinorsFragment", 1, "onMinorsLoginInterrupt: mapId=" + mapId + ", exitCode=" + exitCode + ", msg=" + msg2);
                final MinorsFragment minorsFragment = MinorsFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment$onCreate$notifier$1$onLoginInterrupt$1
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
                        FragmentActivity activity3 = MinorsFragment.this.getActivity();
                        if (activity3 != null) {
                            activity3.finish();
                        }
                        FragmentActivity activity4 = MinorsFragment.this.getActivity();
                        if (activity4 != null) {
                            activity4.overridePendingTransition(0, 0);
                        }
                    }
                });
            }
        };
        activity = getActivity();
        if (activity == null) {
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }
}

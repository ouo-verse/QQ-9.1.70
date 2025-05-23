package com.tencent.mobileqq.register.util;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfoList;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\r\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J,\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/register/util/c;", "", "", "consecutiveString", "", "maxConsecutiveSize", HippyControllerProps.STRING, "", "e", "", "ch", "f", "b", "d", ReportConstant.COSTREPORT_PREFIX, "c", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "list", "", "g", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "scene", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lkotlin/Function0;", "func", h.F, "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f280585a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/register/util/c$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f280586a;

        a(Function0<Unit> function0) {
            this.f280586a = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f280586a.invoke();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27211);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f280585a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e(String consecutiveString, int maxConsecutiveSize, String string) {
        boolean contains$default;
        int length = consecutiveString.length() - maxConsecutiveSize;
        for (int i3 = 0; i3 < length; i3++) {
            String substring = consecutiveString.substring(i3, i3 + maxConsecutiveSize + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) substring, false, 2, (Object) null);
            if (contains$default) {
                return true;
            }
        }
        return false;
    }

    private final boolean f(char ch5) {
        return Character.isLetter(ch5) | Character.isDigit(ch5);
    }

    @NotNull
    public final List<ZPlanAvatarInfo> a() {
        List<ZPlanAvatarInfo> emptyList;
        List<ZPlanAvatarInfo> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        ZPlanAvatarInfoList zPlanAvatarInfoList = (ZPlanAvatarInfoList) from.decodeParcelable("qq_loginzplan_avatar_info", ZPlanAvatarInfoList.class, null);
        if (zPlanAvatarInfoList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<ZPlanAvatarInfo> a16 = zPlanAvatarInfoList.a();
        if (a16 == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        return a16;
    }

    public final boolean b(@Nullable String string) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) string)).booleanValue();
        }
        if (string == null) {
            return false;
        }
        if (string.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        int length = string.length();
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = string.charAt(i3);
            if (Character.isDigit(charAt)) {
                z17 = true;
            } else if (Character.isLetter(charAt)) {
                z18 = true;
            } else {
                z19 = true;
            }
        }
        if ((!z17 || !z18) && ((!z17 || !z19) && (!z18 || !z19))) {
            return false;
        }
        return true;
    }

    public final boolean c(@Nullable String s16) {
        int indexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16)).booleanValue();
        }
        boolean z16 = false;
        if (s16 != null) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) s16, " ", 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                z16 = true;
            }
        }
        return !z16;
    }

    public final boolean d(@Nullable String string, int maxConsecutiveSize) {
        boolean z16;
        CharSequence reversed;
        CharSequence reversed2;
        CharSequence reversed3;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) string, maxConsecutiveSize)).booleanValue();
        }
        if (string != null) {
            if (string.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (!e("abcdefghijklmnopqrstuvwxyz", maxConsecutiveSize, string)) {
                    reversed = StringsKt___StringsKt.reversed((CharSequence) "abcdefghijklmnopqrstuvwxyz");
                    if (!e(reversed.toString(), maxConsecutiveSize, string) && !e("ABCDEFGHIJKLMNOPQRSTUVWXYZ", maxConsecutiveSize, string)) {
                        reversed2 = StringsKt___StringsKt.reversed((CharSequence) "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                        if (!e(reversed2.toString(), maxConsecutiveSize, string) && !e("0123456789", maxConsecutiveSize, string)) {
                            reversed3 = StringsKt___StringsKt.reversed((CharSequence) "0123456789");
                            if (!e(reversed3.toString(), maxConsecutiveSize, string)) {
                                int length = string.length() - maxConsecutiveSize;
                                for (int i3 = 0; i3 < length; i3++) {
                                    String substring = string.substring(i3, i3 + maxConsecutiveSize + 1);
                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                    if (f(substring.charAt(0))) {
                                        int i16 = 0;
                                        while (true) {
                                            if (i16 < substring.length()) {
                                                if (substring.charAt(i16) == substring.charAt(0)) {
                                                    z18 = true;
                                                } else {
                                                    z18 = false;
                                                }
                                                if (!z18) {
                                                    z17 = false;
                                                    break;
                                                }
                                                i16++;
                                            } else {
                                                z17 = true;
                                                break;
                                            }
                                        }
                                        if (z17) {
                                            return true;
                                        }
                                    }
                                }
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void g(@Nullable List<ZPlanAvatarInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        ZPlanAvatarInfoList zPlanAvatarInfoList = new ZPlanAvatarInfoList(list);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeParcelable("qq_loginzplan_avatar_info", zPlanAvatarInfoList);
    }

    public final void h(@NotNull Activity activity, @NotNull String scene, @NotNull String permission, @NotNull Function0<Unit> func) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, activity, scene, permission, func);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(func, "func");
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, scene));
        Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(\n       \u2026SS_CARD, scene)\n        )");
        if (qQPermission.hasPermission(permission) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qQPermission.requestPermissions(new String[]{permission}, 2, new a(func));
        } else {
            func.invoke();
        }
    }
}

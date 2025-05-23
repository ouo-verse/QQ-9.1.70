package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.leba.core.BasePluginDataManager;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.impl.LebaHelperServiceImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/leba/business/k;", "", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "info", "e", "", "redTypeInfoList", "d", "", "", "c", "b", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "a", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f240118a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17220);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f240118a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Set<Long> c() {
        HashSet hashSet = new HashSet();
        BasePluginDataManager a16 = com.tencent.mobileqq.leba.core.b.a();
        if (a16 == null) {
            QLog.e("LebaTabRedTouchHelper", 1, "getTabRedTypeInfo manager is null");
            return hashSet;
        }
        List<n> f16 = a16.f();
        if (f16 != null && !f16.isEmpty()) {
            int size = f16.size();
            for (int i3 = 0; i3 < size; i3++) {
                n nVar = f16.get(i3);
                if (nVar != null) {
                    try {
                        hashSet.add(Long.valueOf(nVar.f240504a));
                    } catch (Exception e16) {
                        QLog.e("LebaTabRedTouchHelper", 1, "getTabRedTypeInfo catch exception: ", e16);
                    }
                }
            }
        }
        return hashSet;
    }

    private final RedTypeInfo d(List<? extends RedTypeInfo> redTypeInfoList) {
        Integer num;
        Integer intOrNull;
        int i3;
        Integer intOrNull2;
        RedTypeInfo redTypeInfo = null;
        for (RedTypeInfo redTypeInfo2 : redTypeInfoList) {
            if (redTypeInfo != null) {
                num = Integer.valueOf(redTypeInfo.getRedType());
            } else {
                num = null;
            }
            QLog.d("LebaTabRedTouchHelper", 2, "mergeRedTypeInfo " + num + ", " + redTypeInfo2.getRedType());
            if (redTypeInfo != null) {
                int redType = redTypeInfo.getRedType();
                if (redType != 0) {
                    if (redType != 4) {
                        if (redType != 5) {
                            QLog.e("LebaTabRedTouchHelper", 1, "mergeRedTypeInfo unsupported redType: " + redTypeInfo.getRedType() + " ");
                        } else if (redTypeInfo2.getRedType() == 5) {
                            String redContent = redTypeInfo.getRedContent();
                            Intrinsics.checkNotNullExpressionValue(redContent, "cur.redContent");
                            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(redContent);
                            int i16 = 0;
                            if (intOrNull != null) {
                                i3 = intOrNull.intValue();
                            } else {
                                i3 = 0;
                            }
                            String redContent2 = redTypeInfo2.getRedContent();
                            Intrinsics.checkNotNullExpressionValue(redContent2, "redTypeInfo.redContent");
                            intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(redContent2);
                            if (intOrNull2 != null) {
                                i16 = intOrNull2.intValue();
                            }
                            redTypeInfo.setRedContent(String.valueOf(i3 + i16));
                        }
                    } else if (redTypeInfo2.getRedType() == 5) {
                    }
                } else if (redTypeInfo2.getRedType() != 5 && redTypeInfo2.getRedType() != 4) {
                }
            }
            redTypeInfo = redTypeInfo2;
        }
        if (redTypeInfo != null) {
            redTypeInfo.setRedDesc("{'cn':'#FF0000'}");
        }
        return redTypeInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final RedTypeInfo e(RedTypeInfo info) {
        String str;
        CharSequence trim;
        Integer intOrNull;
        if (info == null) {
            return null;
        }
        int redType = info.getRedType();
        if (redType != 0) {
            int i3 = 0;
            if (redType != 4) {
                if (redType != 5) {
                    QLog.e("LebaTabRedTouchHelper", 1, "transValidRedTouchInfo unSupport redType " + info.getRedType());
                } else {
                    String redContent = info.getRedContent();
                    if (redContent != null && intOrNull != null) {
                        i3 = intOrNull.intValue();
                    }
                    if (i3 > 0) {
                        return info;
                    }
                }
            } else {
                String redDesc = info.getRedDesc();
                if (redDesc != null) {
                    trim = StringsKt__StringsKt.trim((CharSequence) redDesc);
                    str = trim.toString();
                } else {
                    str = null;
                }
                if (str == null || str.length() == 0) {
                    i3 = 1;
                }
                if (i3 == 0) {
                    return info;
                }
            }
            return null;
        }
        return info;
    }

    @Nullable
    public final BusinessInfoCheckUpdate.RedTypeInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("TianshuRedTouch");
        sb5.append(" ");
        sb5.append("tabIndex=34");
        sb5.append(" ");
        sb5.append("appSet=");
        sb5.append(0);
        sb5.append(" ");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = null;
        if (peekAppRuntime == null) {
            sb5.append("runtime null");
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet = ((IRedTouchManager) runtimeService).requestAppInfoListByAppSet(0);
        if (requestAppInfoListByAppSet != null && requestAppInfoListByAppSet.size() != 0) {
            Set<Long> c16 = c();
            if (c16 != null && c16.size() != 0) {
                if (!c16.contains(Long.valueOf(LebaHelperServiceImpl.redTouchDongTaiPath))) {
                    c16 = CollectionsKt___CollectionsKt.toMutableSet(c16);
                    if (c16 == null || c16.size() == 0) {
                        return null;
                    }
                    c16.add(Long.valueOf(LebaHelperServiceImpl.redTouchDongTaiPath));
                }
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = null;
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = null;
                for (BusinessInfoCheckUpdate.AppInfo appInfo : requestAppInfoListByAppSet) {
                    if (appInfo == null) {
                        sb5.append("appInfo null");
                    } else {
                        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo4 = appInfo.red_display_info.tab_display_info.get();
                        sb5.append("path=");
                        sb5.append(appInfo.path.get());
                        sb5.append(" ");
                        if (appInfo.mission_level.get() != 0) {
                            sb5.append(" mission_level ");
                            sb5.append(appInfo.mission_level.get());
                        } else if (!com.tencent.mobileqq.leba.core.f.v(peekAppRuntime, appInfo.uiAppId.get(), c16)) {
                            sb5.append("dot show");
                        } else {
                            TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
                            String str = appInfo.path.get();
                            Intrinsics.checkNotNullExpressionValue(str, "appInfo.path.get()");
                            if (companion.b(str)) {
                                com.tencent.mobileqq.tianshu.observer.d dVar = com.tencent.mobileqq.tianshu.observer.d.f293094a;
                                String str2 = appInfo.path.get();
                                Intrinsics.checkNotNullExpressionValue(str2, "appInfo.path.get()");
                                if (!dVar.a(str2)) {
                                    sb5.append("delayShow=");
                                    sb5.append(appInfo.path.get());
                                    sb5.append(" ");
                                }
                            }
                            sb5.append("redType=");
                            sb5.append(appInfo.type.get());
                            sb5.append(" ");
                            sb5.append("num=");
                            sb5.append(appInfo.num.get());
                            sb5.append(" ");
                            sb5.append("iNewFlag=");
                            sb5.append(appInfo.iNewFlag.get());
                            sb5.append(" ");
                            if (appInfo.type.get() == 8) {
                                if (!com.tencent.mobileqq.tianshu.ui.b.e(appInfo).booleanValue()) {
                                    sb5.append("Invalid red number");
                                    sb5.append(" ");
                                } else {
                                    if (com.tencent.mobileqq.leba.feed.d.a() && com.tencent.mobileqq.tianshu.ui.a.a(appInfo)) {
                                        if (!appInfo.path.get().equals(LebaHelperServiceImpl.redTouchDongTaiPath + ".0")) {
                                            redTypeInfo3 = new BusinessInfoCheckUpdate.RedTypeInfo();
                                            redTypeInfo3.red_type.set(0);
                                        }
                                    }
                                    if (redTypeInfo2 == null) {
                                        redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
                                        redTypeInfo2.red_type.set(5);
                                        redTypeInfo2.red_content.set("0");
                                    }
                                    try {
                                        PBStringField pBStringField = redTypeInfo2.red_content;
                                        String str3 = pBStringField.get();
                                        Intrinsics.checkNotNullExpressionValue(str3, "tabNumRedTypeInfo.red_content.get()");
                                        int parseInt = Integer.parseInt(str3) + com.tencent.mobileqq.tianshu.ui.b.a(appInfo);
                                        StringBuilder sb6 = new StringBuilder();
                                        sb6.append(parseInt);
                                        pBStringField.set(sb6.toString());
                                    } catch (NumberFormatException e16) {
                                        sb5.append("error getRedTypeInfo");
                                        sb5.append(e16);
                                    }
                                }
                            } else if (redTypeInfo3 == null || redTypeInfo3.red_priority.get() < redTypeInfo4.red_priority.get()) {
                                if (com.tencent.mobileqq.tianshu.ui.a.d(appInfo)) {
                                    sb5.append("redType=dot ");
                                    if (appInfo.path.get().equals(String.valueOf(LebaHelperServiceImpl.redTouchDongTaiPath)) && j.f240113a.c() && com.tencent.mobileqq.tianshu.ui.b.d(appInfo)) {
                                        redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                                        redTypeInfo.red_type.set(98);
                                        redTypeInfo.red_content.set("\u66f4\u65b0");
                                    }
                                    redTypeInfo3 = redTypeInfo4;
                                }
                            }
                        }
                    }
                }
                QLog.i("LebaTabRedTouchHelper", 1, String.valueOf(sb5));
                if (redTypeInfo != null) {
                    return redTypeInfo;
                }
                if (redTypeInfo2 != null) {
                    return redTypeInfo2;
                }
                return redTypeInfo3;
            }
            sb5.append("plugin null");
            return null;
        }
        sb5.append("appInfoList null");
        return null;
    }

    @Nullable
    public final RedTypeInfo b() {
        Integer num;
        Integer num2;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        BasePluginDataManager a16 = com.tencent.mobileqq.leba.core.b.a();
        String str2 = null;
        if (a16 == null) {
            QLog.e("LebaTabRedTouchHelper", 1, "getTabRedTypeInfo manager is null");
            return null;
        }
        List<n> f16 = a16.f();
        ArrayList arrayList = new ArrayList();
        for (n nVar : f16) {
            BaseLebaPluginItem d16 = LebaPluginProxy.INSTANCE.d(nVar.f240504a);
            if (d16 != null) {
                try {
                    RedTypeInfo e16 = e(d16.w());
                    long j3 = nVar.f240504a;
                    if (e16 != null) {
                        num2 = Integer.valueOf(e16.getRedType());
                    } else {
                        num2 = null;
                    }
                    if (e16 != null) {
                        str = e16.getRedContent();
                    } else {
                        str = null;
                    }
                    QLog.d("LebaTabRedTouchHelper", 2, "getPluginRedTypeInfo [" + j3 + "]: " + num2 + ", " + str);
                    if (e16 != null) {
                        arrayList.add(e16);
                    }
                } catch (Exception e17) {
                    QLog.e("LebaTabRedTouchHelper", 1, "getTabRedTypeInfo catch exception: " + nVar.f240504a + " ", e17);
                }
            }
        }
        RedTypeInfo d17 = d(arrayList);
        if (d17 != null) {
            num = Integer.valueOf(d17.getRedType());
        } else {
            num = null;
        }
        if (d17 != null) {
            str2 = d17.getRedContent();
        }
        QLog.d("LebaTabRedTouchHelper", 2, "getTabRedTypeInfo mergeRedTypeInfo = " + num + ", " + str2);
        return d17;
    }
}

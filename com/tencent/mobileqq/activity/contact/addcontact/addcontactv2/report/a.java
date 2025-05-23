package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report;

import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/report/a;", "", "", "costTime", "", "errMsg", "", "listCount", "", "a", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "pageType", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f180889a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public /* synthetic */ class C7144a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180890a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49816);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddContactDataType.GUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddContactDataType.FLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f180890a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f180889a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(long costTime, @NotNull String errMsg, int listCount) {
        Map<String, ? extends Object> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(costTime), errMsg, Integer.valueOf(listCount));
            return;
        }
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cost_time", String.valueOf(costTime)), TuplesKt.to("error", errMsg), TuplesKt.to("section_count", String.valueOf(listCount)));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("new_friend_group_show", mapOf);
    }

    public final void b(@NotNull AddContactDataType pageType, long costTime, @NotNull String errMsg, int listCount) {
        int i3;
        Map<String, ? extends Object> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, pageType, Long.valueOf(costTime), errMsg, Integer.valueOf(listCount));
            return;
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        int i16 = C7144a.f180890a[pageType.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        i3 = 4;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i3 = 3;
                }
            } else {
                i3 = 2;
            }
        } else {
            i3 = 1;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(MiniAppPlugin.ATTR_PAGE_TYPE, String.valueOf(i3)), TuplesKt.to("cost_time", String.valueOf(costTime)), TuplesKt.to("error", errMsg), TuplesKt.to("list_count", String.valueOf(listCount)));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("new_friend_group_more_show", mapOf);
    }
}

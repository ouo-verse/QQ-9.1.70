package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model;

import com.tencent.mobileqq.data.QZoneInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/g;", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;", "titleItem", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/c;", "dataList", "Lcom/tencent/mobileqq/data/QZoneInfo;", "qZoneInfo", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;", "d", "()Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/tencent/mobileqq/data/QZoneInfo;", "getQZoneInfo", "()Lcom/tencent/mobileqq/data/QZoneInfo;", "<init>", "(Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;Ljava/util/List;Lcom/tencent/mobileqq/data/QZoneInfo;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e titleItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> dataList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QZoneInfo qZoneInfo;

    public g(@NotNull e titleItem, @NotNull List<c> dataList, @Nullable QZoneInfo qZoneInfo) {
        Intrinsics.checkNotNullParameter(titleItem, "titleItem");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, titleItem, dataList, qZoneInfo);
            return;
        }
        this.titleItem = titleItem;
        this.dataList = dataList;
        this.qZoneInfo = qZoneInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ g b(g gVar, e eVar, List list, QZoneInfo qZoneInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eVar = gVar.titleItem;
        }
        if ((i3 & 2) != 0) {
            list = gVar.dataList;
        }
        if ((i3 & 4) != 0) {
            qZoneInfo = gVar.qZoneInfo;
        }
        return gVar.a(eVar, list, qZoneInfo);
    }

    @NotNull
    public final g a(@NotNull e titleItem, @NotNull List<c> dataList, @Nullable QZoneInfo qZoneInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (g) iPatchRedirector.redirect((short) 8, this, titleItem, dataList, qZoneInfo);
        }
        Intrinsics.checkNotNullParameter(titleItem, "titleItem");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        return new g(titleItem, dataList, qZoneInfo);
    }

    @NotNull
    public final List<c> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.dataList;
    }

    @NotNull
    public final e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.titleItem;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (Intrinsics.areEqual(this.titleItem, gVar.titleItem) && Intrinsics.areEqual(this.dataList, gVar.dataList) && Intrinsics.areEqual(this.qZoneInfo, gVar.qZoneInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int hashCode2 = ((this.titleItem.hashCode() * 31) + this.dataList.hashCode()) * 31;
        QZoneInfo qZoneInfo = this.qZoneInfo;
        if (qZoneInfo == null) {
            hashCode = 0;
        } else {
            hashCode = qZoneInfo.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "AddContactRecommendDataWrapper(titleItem=" + this.titleItem + ", dataList=" + this.dataList + ", qZoneInfo=" + this.qZoneInfo + ")";
    }
}

package com.tencent.mobileqq.sharepanel.multiSelect.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "contact", "", "Q1", "S1", "", "getLogTag", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "N1", "P1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "selectedContactListLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L1", "contactListLiveData", "", BdhLogUtil.LogTag.Tag_Conn, "O1", "showSelectedContactListDialogEvent", "Lkotlin/Function1;", "", "D", "Lkotlin/jvm/functions/Function1;", "getShowDialog", "()Lkotlin/jvm/functions/Function1;", "R1", "(Lkotlin/jvm/functions/Function1;)V", "showDialog", "<init>", "()V", "E", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> showSelectedContactListDialogEvent;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Integer, Unit> showDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<SharePanelContactItem>> selectedContactListLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<SharePanelContactItem>> contactListLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a$a;", "", "", "MAX_SELECTED_NUM", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.vm.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.selectedContactListLiveData = new MutableLiveData<>(new ArrayList());
        this.contactListLiveData = new MutableLiveData<>(new ArrayList());
        this.showSelectedContactListDialogEvent = new MutableLiveData<>(Boolean.FALSE);
    }

    private final void Q1(SharePanelContactItem contact) {
        List<SharePanelContactItem> value;
        List<SharePanelContactItem> value2 = this.contactListLiveData.getValue();
        if (value2 == null || (value = this.selectedContactListLiveData.getValue()) == null) {
            return;
        }
        if (value.size() == 0) {
            Iterator<T> it = value2.iterator();
            while (it.hasNext()) {
                ((SharePanelContactItem) it.next()).l(true);
            }
        }
        if (value.size() < 9) {
            SharePanelContactItem sharePanelContactItem = null;
            for (SharePanelContactItem sharePanelContactItem2 : value2) {
                if (Intrinsics.areEqual(sharePanelContactItem2.e(), contact.e()) && sharePanelContactItem2.f() == contact.f()) {
                    sharePanelContactItem2.m(true);
                    sharePanelContactItem = sharePanelContactItem2;
                }
            }
            if (sharePanelContactItem != null) {
                value.add(sharePanelContactItem);
                this.selectedContactListLiveData.postValue(value);
                this.contactListLiveData.postValue(value2);
                return;
            }
            return;
        }
        Function1<? super Integer, Unit> function1 = this.showDialog;
        if (function1 != null) {
            function1.invoke(9);
        }
    }

    private final void S1(SharePanelContactItem contact) {
        List<SharePanelContactItem> value;
        List<SharePanelContactItem> value2 = this.contactListLiveData.getValue();
        if (value2 == null || (value = this.selectedContactListLiveData.getValue()) == null) {
            return;
        }
        List<SharePanelContactItem> list = value2;
        SharePanelContactItem sharePanelContactItem = null;
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SharePanelContactItem sharePanelContactItem2 = (SharePanelContactItem) obj;
            if (Intrinsics.areEqual(sharePanelContactItem2.e(), contact.e()) && sharePanelContactItem2.f() == contact.f()) {
                sharePanelContactItem2.m(false);
                sharePanelContactItem = sharePanelContactItem2;
            }
            i3 = i16;
        }
        if (sharePanelContactItem != null) {
            value.remove(contact);
            if (value.size() == 0) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ((SharePanelContactItem) it.next()).l(false);
                }
            }
            this.selectedContactListLiveData.postValue(value);
            this.contactListLiveData.postValue(value2);
        }
    }

    @NotNull
    public final MutableLiveData<List<SharePanelContactItem>> L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.contactListLiveData;
    }

    @NotNull
    public final MutableLiveData<List<SharePanelContactItem>> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.selectedContactListLiveData;
    }

    @NotNull
    public final ArrayList<ResultRecord> N1() {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList<ResultRecord> arrayList = new ArrayList<>();
        List<SharePanelContactItem> value = this.selectedContactListLiveData.getValue();
        if (value == null) {
            return arrayList;
        }
        List<SharePanelContactItem> list = value;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (SharePanelContactItem sharePanelContactItem : list) {
            arrayList2.add(new ResultRecord(sharePanelContactItem.e(), sharePanelContactItem.b(), sharePanelContactItem.f(), sharePanelContactItem.a()));
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @NotNull
    public final MutableLiveData<Boolean> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.showSelectedContactListDialogEvent;
    }

    public final void P1(@NotNull SharePanelContactItem contact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) contact);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        List<SharePanelContactItem> value = this.selectedContactListLiveData.getValue();
        if (value == null) {
            return;
        }
        if (value.contains(contact)) {
            S1(contact);
        } else {
            Q1(contact);
        }
    }

    public final void R1(@Nullable Function1<? super Integer, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) function1);
        } else {
            this.showDialog = function1;
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MultiSelectContactVM";
    }
}

package com.tencent.mobileqq.search.business.contact.viewmodel;

import android.support.annotation.UiThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.coroutine.b;
import com.tencent.mobileqq.search.business.contact.entity.ContactsSearchItemData;
import com.tencent.mobileqq.search.business.contact.entity.UIType;
import com.tencent.mobileqq.search.business.contact.i;
import com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchRepo;
import com.tencent.mobileqq.search.model.k;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ^2\u00020\u0001:\u0001_B\u0007\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002Ju\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000f\u001a\u00020\u000e2.\u0010\u0014\u001a*\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00102\u0006\u0010\u0015\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020!J\u0006\u0010%\u001a\u00020\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0004H\u0007J\u0006\u0010(\u001a\u00020\u0002J\u0006\u0010)\u001a\u00020\u0002R%\u00100\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u00040\u00040*8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R%\u00103\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u00040\u00040*8\u0006\u00a2\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b2\u0010/R%\u00106\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u00040\u00040*8\u0006\u00a2\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010/R,\u0010:\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u0012\u0012\u0004\u0012\u00020\u0004070*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010-R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00180;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00180;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010E\u001a\u0004\bF\u0010GR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020I0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010=R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR3\u0010W\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u0012\u0012\u0004\u0012\u00020\u0004070R8FX\u0086\u0084\u0002\u00a2\u0006\f\u001a\u0004\bS\u0010T*\u0004\bU\u0010VR\u0016\u0010[\u001a\u0004\u0018\u00010X8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bY\u0010Z\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;", "Landroidx/lifecycle/ViewModel;", "", "q2", "", "needScrollTop", "j2", "m2", ICustomDataEditor.NUMBER_PARAM_2, "T", "", "keyword", "Lkotlin/Function0;", "shouldRequest", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "", "loadFunction", "logTag", "i2", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/search/business/contact/entity/c;", SemanticAttributes.DbSystemValues.H2, "", IProfileCardConst.KEY_FROM_TYPE, ForwardRecentActivity.KEY_SEARCH_SOURCE, "Lcom/tencent/mobileqq/search/business/contact/viewmodel/a;", "params", "e2", "destroy", "", "delayTime", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "g2", "W1", "multiSelect", "p2", "l2", "o2", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "Z1", "()Landroidx/lifecycle/MutableLiveData;", "collapseContactsBuddies", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f2", "isSearchFragmentShowing", BdhLogUtil.LogTag.Tag_Conn, ICustomDataEditor.STRING_ARRAY_PARAM_2, "currentIsMultiSelect", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType;", "D", "_finalShowingResult", "", "E", "Ljava/util/List;", "buddiesResult", UserInfo.SEX_FEMALE, "troopsResult", "G", "I", "H", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo;", "Lkotlin/Lazy;", "d2", "()Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchRepo;", "repo", "Lcom/tencent/mobileqq/search/business/contact/entity/UIType$d;", "J", "emptyLoadingView", "K", "Lcom/tencent/mobileqq/search/business/contact/viewmodel/a;", "c2", "()Lcom/tencent/mobileqq/search/business/contact/viewmodel/a;", "setParams$qqsearch_impl_release", "(Lcom/tencent/mobileqq/search/business/contact/viewmodel/a;)V", "Landroidx/lifecycle/LiveData;", "b2", "()Landroidx/lifecycle/LiveData;", "getFinalShowingResult$delegate", "(Lcom/tencent/mobileqq/search/business/contact/viewmodel/ContactsSearchViewmodel;)Ljava/lang/Object;", "finalShowingResult", "Lcom/tencent/common/app/AppInterface;", "X1", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "<init>", "()V", "L", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ContactsSearchViewmodel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> currentIsMultiSelect;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<List<UIType>, Boolean>> _finalShowingResult;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<ContactsSearchItemData> buddiesResult;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<ContactsSearchItemData> troopsResult;

    /* renamed from: G, reason: from kotlin metadata */
    private int fromType;

    /* renamed from: H, reason: from kotlin metadata */
    private int searchSource;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy repo;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final List<UIType.d> emptyLoadingView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ContactsSearchViewModeParams params;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> collapseContactsBuddies;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isSearchFragmentShowing;

    public ContactsSearchViewmodel() {
        Lazy lazy;
        List<UIType.d> listOf;
        Boolean bool = Boolean.TRUE;
        this.collapseContactsBuddies = new MutableLiveData<>(bool);
        this.isSearchFragmentShowing = new MutableLiveData<>(Boolean.FALSE);
        this.currentIsMultiSelect = new MutableLiveData<>(bool);
        this._finalShowingResult = new MutableLiveData<>();
        this.buddiesResult = new ArrayList();
        this.troopsResult = new ArrayList();
        this.fromType = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ContactsSearchRepo>() { // from class: com.tencent.mobileqq.search.business.contact.viewmodel.ContactsSearchViewmodel$repo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ContactsSearchRepo invoke() {
                int i3;
                i3 = ContactsSearchViewmodel.this.fromType;
                return new ContactsSearchRepo(i3);
            }
        });
        this.repo = lazy;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(UIType.d.f282919a);
        this.emptyLoadingView = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContactsSearchRepo d2() {
        return (ContactsSearchRepo) this.repo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ContactsSearchItemData> h2(String keyword) {
        int collectionSizeOrDefault;
        List<ContactsSearchItemData> emptyList;
        AppInterface X1 = X1();
        if (X1 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<k> d16 = i.d(X1, keyword, this.searchSource, this.fromType);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(d16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (k kVar : d16) {
            String l3 = kVar.l();
            Intrinsics.checkNotNullExpressionValue(l3, "it.uin");
            arrayList.add(new ContactsSearchItemData(l3, kVar));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object i2(String str, Function0<Boolean> function0, IPerformanceReportTask iPerformanceReportTask, Function3<? super String, ? super IPerformanceReportTask, ? super Continuation<? super List<? extends T>>, ? extends Object> function3, String str2, Continuation<? super List<? extends T>> continuation) {
        ContactsSearchViewmodel$loadWithTimeout$1 contactsSearchViewmodel$loadWithTimeout$1;
        Object coroutine_suspended;
        int i3;
        List emptyList;
        int checkRadix;
        List emptyList2;
        try {
            if (continuation instanceof ContactsSearchViewmodel$loadWithTimeout$1) {
                contactsSearchViewmodel$loadWithTimeout$1 = (ContactsSearchViewmodel$loadWithTimeout$1) continuation;
                int i16 = contactsSearchViewmodel$loadWithTimeout$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    contactsSearchViewmodel$loadWithTimeout$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = contactsSearchViewmodel$loadWithTimeout$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = contactsSearchViewmodel$loadWithTimeout$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            str2 = (String) contactsSearchViewmodel$loadWithTimeout$1.L$1;
                            str = (String) contactsSearchViewmodel$loadWithTimeout$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (!function0.invoke().booleanValue()) {
                            int i17 = this.searchSource;
                            checkRadix = CharsKt__CharJVMKt.checkRadix(2);
                            String num = Integer.toString(i17, checkRadix);
                            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                            QLog.d("ContactsSearchViewmodel", 1, "do not request " + str2 + MsgSummary.STR_COLON + num);
                            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                            return emptyList2;
                        }
                        ContactsSearchViewmodel$loadWithTimeout$2 contactsSearchViewmodel$loadWithTimeout$2 = new ContactsSearchViewmodel$loadWithTimeout$2(function3, str, iPerformanceReportTask, null);
                        contactsSearchViewmodel$loadWithTimeout$1.L$0 = str;
                        contactsSearchViewmodel$loadWithTimeout$1.L$1 = str2;
                        contactsSearchViewmodel$loadWithTimeout$1.label = 1;
                        obj = TimeoutKt.withTimeout(10000L, contactsSearchViewmodel$loadWithTimeout$2, contactsSearchViewmodel$loadWithTimeout$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return (List) obj;
                }
            }
            if (i3 == 0) {
            }
            return (List) obj;
        } catch (TimeoutCancellationException unused) {
            QLog.d("ContactsSearchViewmodel", 1, "load " + str2 + " timeout: " + str);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        contactsSearchViewmodel$loadWithTimeout$1 = new ContactsSearchViewmodel$loadWithTimeout$1(this, continuation);
        Object obj2 = contactsSearchViewmodel$loadWithTimeout$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = contactsSearchViewmodel$loadWithTimeout$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j2(boolean needScrollTop) {
        boolean z16;
        List listOf;
        int collectionSizeOrDefault;
        List plus;
        boolean z17;
        boolean z18;
        UIType.CheckStatus checkStatus;
        boolean z19;
        Set<String> j3;
        String str;
        boolean contains;
        Set<String> h16;
        String str2;
        boolean contains2;
        boolean z26;
        List listOf2;
        int collectionSizeOrDefault2;
        int i3;
        List take;
        List plus2;
        boolean z27;
        boolean z28;
        UIType.CheckStatus checkStatus2;
        boolean z29;
        Set<String> j16;
        String str3;
        boolean contains3;
        Set<String> h17;
        String str4;
        boolean contains4;
        ArrayList arrayList = new ArrayList();
        Boolean value = this.currentIsMultiSelect.getValue();
        if (value == null) {
            value = Boolean.TRUE;
        }
        boolean booleanValue = value.booleanValue();
        if (!this.buddiesResult.isEmpty()) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new UIType.TitleUI("\u8054\u7cfb\u4eba", false));
            List list = listOf2;
            List<ContactsSearchItemData> list2 = this.buddiesResult;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (ContactsSearchItemData contactsSearchItemData : list2) {
                UIType.CheckStatus checkStatus3 = UIType.CheckStatus.UNCHECKED;
                ContactsSearchViewModeParams contactsSearchViewModeParams = this.params;
                if (contactsSearchViewModeParams != null && (h17 = contactsSearchViewModeParams.h()) != null) {
                    k model = contactsSearchItemData.getModel();
                    if (model != null) {
                        str4 = model.l();
                    } else {
                        str4 = null;
                    }
                    contains4 = CollectionsKt___CollectionsKt.contains(h17, str4);
                    if (contains4) {
                        z27 = true;
                        if (!z27) {
                            checkStatus2 = UIType.CheckStatus.DISABLED;
                            z29 = !i.e(this);
                        } else {
                            ContactsSearchViewModeParams contactsSearchViewModeParams2 = this.params;
                            if (contactsSearchViewModeParams2 != null && (j16 = contactsSearchViewModeParams2.j()) != null) {
                                k model2 = contactsSearchItemData.getModel();
                                if (model2 != null) {
                                    str3 = model2.l();
                                } else {
                                    str3 = null;
                                }
                                contains3 = CollectionsKt___CollectionsKt.contains(j16, str3);
                                if (contains3) {
                                    z28 = true;
                                    if (!z28) {
                                        checkStatus2 = UIType.CheckStatus.CHECKED;
                                    } else {
                                        checkStatus2 = UIType.CheckStatus.UNCHECKED;
                                    }
                                    z29 = true;
                                }
                            }
                            z28 = false;
                            if (!z28) {
                            }
                            z29 = true;
                        }
                        arrayList2.add(new UIType.a(contactsSearchItemData, checkStatus2, booleanValue, z29));
                    }
                }
                z27 = false;
                if (!z27) {
                }
                arrayList2.add(new UIType.a(contactsSearchItemData, checkStatus2, booleanValue, z29));
            }
            Boolean value2 = this.collapseContactsBuddies.getValue();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(value2, bool) && (!this.troopsResult.isEmpty())) {
                i3 = 3;
            } else {
                i3 = Integer.MAX_VALUE;
            }
            take = CollectionsKt___CollectionsKt.take(arrayList2, i3);
            plus2 = CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) take);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, plus2);
            if (this.buddiesResult.size() > 3 && (!this.troopsResult.isEmpty())) {
                arrayList.add(new UIType.LoadMoreUI(Intrinsics.areEqual(this.collapseContactsBuddies.getValue(), bool)));
            }
        }
        if (!this.troopsResult.isEmpty()) {
            if (i.e(this)) {
                ContactsSearchViewModeParams contactsSearchViewModeParams3 = this.params;
                if (contactsSearchViewModeParams3 != null && contactsSearchViewModeParams3.getFromType() == 8) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    z16 = false;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(new UIType.TitleUI("\u7fa4\u804a", z16));
                    List list3 = listOf;
                    List<ContactsSearchItemData> list4 = this.troopsResult;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                    for (ContactsSearchItemData contactsSearchItemData2 : list4) {
                        UIType.CheckStatus checkStatus4 = UIType.CheckStatus.UNCHECKED;
                        ContactsSearchViewModeParams contactsSearchViewModeParams4 = this.params;
                        if (contactsSearchViewModeParams4 != null && (h16 = contactsSearchViewModeParams4.h()) != null) {
                            k model3 = contactsSearchItemData2.getModel();
                            if (model3 != null) {
                                str2 = model3.l();
                            } else {
                                str2 = null;
                            }
                            contains2 = CollectionsKt___CollectionsKt.contains(h16, str2);
                            if (contains2) {
                                z17 = true;
                                if (!z17) {
                                    checkStatus = UIType.CheckStatus.DISABLED;
                                    z19 = !i.e(this);
                                } else {
                                    ContactsSearchViewModeParams contactsSearchViewModeParams5 = this.params;
                                    if (contactsSearchViewModeParams5 != null && (j3 = contactsSearchViewModeParams5.j()) != null) {
                                        k model4 = contactsSearchItemData2.getModel();
                                        if (model4 != null) {
                                            str = model4.l();
                                        } else {
                                            str = null;
                                        }
                                        contains = CollectionsKt___CollectionsKt.contains(j3, str);
                                        if (contains) {
                                            z18 = true;
                                            if (!z18) {
                                                checkStatus = UIType.CheckStatus.CHECKED;
                                            } else {
                                                checkStatus = UIType.CheckStatus.UNCHECKED;
                                            }
                                            z19 = true;
                                        }
                                    }
                                    z18 = false;
                                    if (!z18) {
                                    }
                                    z19 = true;
                                }
                                arrayList3.add(new UIType.f(contactsSearchItemData2, checkStatus, booleanValue, z19));
                            }
                        }
                        z17 = false;
                        if (!z17) {
                        }
                        arrayList3.add(new UIType.f(contactsSearchItemData2, checkStatus, booleanValue, z19));
                    }
                    plus = CollectionsKt___CollectionsKt.plus((Collection) list3, (Iterable) arrayList3);
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, plus);
                }
            }
            z16 = true;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new UIType.TitleUI("\u7fa4\u804a", z16));
            List list32 = listOf;
            List<ContactsSearchItemData> list42 = this.troopsResult;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list42, 10);
            ArrayList arrayList32 = new ArrayList(collectionSizeOrDefault);
            while (r4.hasNext()) {
            }
            plus = CollectionsKt___CollectionsKt.plus((Collection) list32, (Iterable) arrayList32);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, plus);
        }
        this._finalShowingResult.postValue(new Pair<>(arrayList, Boolean.valueOf(needScrollTop)));
    }

    static /* synthetic */ void k2(ContactsSearchViewmodel contactsSearchViewmodel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        contactsSearchViewmodel.j2(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m2() {
        if ((this.searchSource & 1) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n2() {
        int i3 = this.searchSource;
        if ((i3 & 16) == 0 && (i3 & 2097152) == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q2() {
        boolean z16;
        boolean z17;
        int i3;
        ContactsSearchRepo.RequestParams params = d2().getParams();
        ContactsSearchViewModeParams contactsSearchViewModeParams = this.params;
        int i16 = 0;
        if (contactsSearchViewModeParams != null && contactsSearchViewModeParams.getFilterRobot()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 1;
        } else {
            ContactsSearchViewModeParams contactsSearchViewModeParams2 = this.params;
            if (contactsSearchViewModeParams2 != null && contactsSearchViewModeParams2.getFilterGroupRobot()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i3 = 2;
            } else {
                i3 = 0;
            }
        }
        params.c(i3);
        ContactsSearchRepo.RequestParams params2 = d2().getParams();
        if (this.searchSource == 1) {
            QLog.d("ContactsSearchViewmodel", 1, "only search buddy");
            i16 = 1;
        }
        params2.d(i16);
    }

    public final void W1() {
        MutableLiveData<Boolean> mutableLiveData = this.collapseContactsBuddies;
        Intrinsics.checkNotNull(mutableLiveData.getValue());
        mutableLiveData.setValue(Boolean.valueOf(!r1.booleanValue()));
        k2(this, false, 1, null);
    }

    @Nullable
    public final AppInterface X1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    @NotNull
    public final MutableLiveData<Boolean> Z1() {
        return this.collapseContactsBuddies;
    }

    @NotNull
    public final MutableLiveData<Boolean> a2() {
        return this.currentIsMultiSelect;
    }

    @NotNull
    public final LiveData<Pair<List<UIType>, Boolean>> b2() {
        return this._finalShowingResult;
    }

    @Nullable
    /* renamed from: c2, reason: from getter */
    public final ContactsSearchViewModeParams getParams() {
        return this.params;
    }

    public final void destroy() {
        d2().h();
    }

    public final void e2(int fromType, int searchSource, @NotNull ContactsSearchViewModeParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.fromType = fromType;
        this.searchSource = searchSource;
        this.currentIsMultiSelect.setValue(Boolean.valueOf(params.getIsMultiSelect()));
        this.params = params;
        d2().g();
    }

    @NotNull
    public final MutableLiveData<Boolean> f2() {
        return this.isSearchFragmentShowing;
    }

    @Nullable
    public final b g2(@NotNull String keyword, long delayTime) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "ContactsSearchViewmodel loadContactsAndGroup", null, null, Boolean.TRUE, new ContactsSearchViewmodel$loadContactsAndGroupHomePage$1(delayTime, this, keyword, null), 6, null);
    }

    public final void l2() {
        k2(this, false, 1, null);
    }

    public final void o2() {
        List<UIType> list;
        if (this.buddiesResult.isEmpty() && this.troopsResult.isEmpty()) {
            Pair<List<UIType>, Boolean> value = this._finalShowingResult.getValue();
            if (value != null) {
                list = value.getFirst();
            } else {
                list = null;
            }
            if (!Intrinsics.areEqual(list, this.emptyLoadingView)) {
                this._finalShowingResult.postValue(new Pair<>(this.emptyLoadingView, Boolean.FALSE));
            }
        }
    }

    @UiThread
    public final void p2(boolean multiSelect) {
        ContactsSearchViewModeParams contactsSearchViewModeParams;
        Set<String> j3;
        this.currentIsMultiSelect.setValue(Boolean.valueOf(multiSelect));
        ContactsSearchViewModeParams contactsSearchViewModeParams2 = this.params;
        if (contactsSearchViewModeParams2 != null) {
            contactsSearchViewModeParams2.w(multiSelect);
        }
        if (!multiSelect && (contactsSearchViewModeParams = this.params) != null && (j3 = contactsSearchViewModeParams.j()) != null) {
            j3.clear();
        }
        k2(this, false, 1, null);
    }
}

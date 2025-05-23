package ai4;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import yh4.ReceiverInfoModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u001e\u0010\r\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R,\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0004\u0012\u00020\u000b0\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR&\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0004\u0012\u00020\u000b0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019\u00a8\u0006$"}, d2 = {"Lai4/e;", "Lai4/d;", "Lyh4/b;", "info", "", "f", "", "sortedReceiverList", "e", "", "list", "", "noAnimate", "d", "Lai4/f;", "cb", "c", "chosenInfo", "b", "reset", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "receiverUpdateCbList", "Ljava/util/List;", "chosenReceiverList", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Landroidx/lifecycle/MutableLiveData;", "chosenReceiverLiveData", "Lkotlin/Pair;", "fakeChosenPair", "receiverList", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<WeakReference<f>> receiverUpdateCbList = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ReceiverInfoModel> chosenReceiverList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<List<ReceiverInfoModel>, Boolean>> chosenReceiverLiveData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Pair<List<ReceiverInfoModel>, Boolean> fakeChosenPair;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ReceiverInfoModel> receiverList;

    public e() {
        ArrayList arrayList = new ArrayList();
        this.chosenReceiverList = arrayList;
        this.chosenReceiverLiveData = new MutableLiveData<>();
        this.fakeChosenPair = new Pair<>(arrayList, Boolean.FALSE);
        this.receiverList = new ArrayList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        if (r8 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008e, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008c, code lost:
    
        if (r4 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized void e(List<ReceiverInfoModel> sortedReceiverList) {
        boolean z16;
        boolean z17;
        PBUInt64Field pBUInt64Field;
        boolean z18;
        PBUInt64Field pBUInt64Field2;
        Object orNull;
        if (this.chosenReceiverList.isEmpty()) {
            this.receiverList.clear();
            this.receiverList.addAll(sortedReceiverList);
            orNull = CollectionsKt___CollectionsKt.getOrNull(sortedReceiverList, 0);
            f((ReceiverInfoModel) orNull);
        } else {
            ReceiverInfoModel receiverInfoModel = this.chosenReceiverList.get(0);
            Iterator<ReceiverInfoModel> it = sortedReceiverList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    ReceiverInfoModel next = it.next();
                    CommonOuterClass$QQUserId uid = receiverInfoModel.getUid();
                    CommonOuterClass$QQUserId uid2 = next.getUid();
                    if (uid.uid.get() != 0) {
                        if (uid2 != null && (pBUInt64Field2 = uid2.uid) != null && uid.uid.get() == pBUInt64Field2.get()) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                    }
                    if (uid.yes_uid.get() != 0) {
                        if (uid2 != null && (pBUInt64Field = uid2.yes_uid) != null && uid.yes_uid.get() == pBUInt64Field.get()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                    }
                    boolean z19 = false;
                    if (z19) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                sortedReceiverList.get(i3).i(true);
                this.receiverList.clear();
                this.receiverList.addAll(sortedReceiverList);
                return;
            }
            Iterator<ReceiverInfoModel> it5 = sortedReceiverList.iterator();
            int i16 = 0;
            while (true) {
                if (it5.hasNext()) {
                    if (it5.next().getPriority() >= receiverInfoModel.getPriority()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 == -1) {
                i16 = sortedReceiverList.size();
            }
            sortedReceiverList.add(Math.max(i16, 0), ReceiverInfoModel.b(receiverInfoModel, null, 0, "", true, false, true, 19, null));
            this.receiverList.clear();
            this.receiverList.addAll(sortedReceiverList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        if (r7 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009d, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x009b, code lost:
    
        if (r5 != false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(ReceiverInfoModel info) {
        Object obj;
        Object obj2;
        int collectionSizeOrDefault;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        boolean z16;
        PBUInt64Field pBUInt64Field;
        boolean z17;
        PBUInt64Field pBUInt64Field2;
        this.chosenReceiverList.clear();
        if (info != null) {
            this.chosenReceiverList.add(info);
        }
        Iterator<T> it = this.receiverList.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (((ReceiverInfoModel) obj2).getChosen()) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        ReceiverInfoModel receiverInfoModel = (ReceiverInfoModel) obj2;
        if (receiverInfoModel != null) {
            receiverInfoModel.i(false);
        }
        Iterator<T> it5 = this.receiverList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            CommonOuterClass$QQUserId uid = ((ReceiverInfoModel) next).getUid();
            if (info != null) {
                commonOuterClass$QQUserId = info.getUid();
            } else {
                commonOuterClass$QQUserId = null;
            }
            if (uid.uid.get() != 0) {
                if (commonOuterClass$QQUserId != null && (pBUInt64Field2 = commonOuterClass$QQUserId.uid) != null && uid.uid.get() == pBUInt64Field2.get()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            if (uid.yes_uid.get() != 0) {
                if (commonOuterClass$QQUserId != null && (pBUInt64Field = commonOuterClass$QQUserId.yes_uid) != null && uid.yes_uid.get() == pBUInt64Field.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            boolean z18 = false;
            if (z18) {
                obj = next;
                break;
            }
        }
        ReceiverInfoModel receiverInfoModel2 = (ReceiverInfoModel) obj;
        if (receiverInfoModel2 != null) {
            receiverInfoModel2.i(true);
        }
        this.chosenReceiverLiveData.postValue(this.fakeChosenPair);
        List<ReceiverInfoModel> list = this.receiverList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it6 = list.iterator();
        while (it6.hasNext()) {
            arrayList.add(ReceiverInfoModel.b((ReceiverInfoModel) it6.next(), null, 0, null, false, false, false, 63, null));
        }
        Iterator<T> it7 = this.receiverUpdateCbList.iterator();
        while (it7.hasNext()) {
            f fVar = (f) ((WeakReference) it7.next()).get();
            if (fVar != null) {
                fVar.onUpdate(arrayList, false);
            }
        }
    }

    @Override // ai4.d
    @NotNull
    public List<ReceiverInfoModel> a() {
        return this.chosenReceiverList;
    }

    @Override // ai4.d
    public synchronized void b(@NotNull ReceiverInfoModel chosenInfo) {
        Intrinsics.checkNotNullParameter(chosenInfo, "chosenInfo");
        f(chosenInfo);
    }

    @Override // ai4.d
    public void c(@NotNull f cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.receiverUpdateCbList.add(new WeakReference<>(cb5));
    }

    @Override // ai4.d
    public synchronized void d(@NotNull List<ReceiverInfoModel> list, boolean noAnimate) {
        List<ReceiverInfoModel> a16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.get(0).getUid().user_from.get() == 4) {
            a16 = g.b(list);
        } else {
            a16 = g.a(list);
        }
        List<ReceiverInfoModel> c16 = g.c(a16);
        e(c16);
        List<ReceiverInfoModel> list2 = c16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(ReceiverInfoModel.b((ReceiverInfoModel) it.next(), null, 0, null, false, false, false, 63, null));
        }
        Iterator<T> it5 = this.receiverUpdateCbList.iterator();
        while (it5.hasNext()) {
            f fVar = (f) ((WeakReference) it5.next()).get();
            if (fVar != null) {
                fVar.onUpdate(arrayList, noAnimate);
            }
        }
    }

    @Override // ai4.d
    public synchronized void reset() {
        List<ReceiverInfoModel> emptyList;
        this.receiverList.clear();
        this.chosenReceiverList.clear();
        this.chosenReceiverLiveData.setValue(null);
        Iterator<T> it = this.receiverUpdateCbList.iterator();
        while (it.hasNext()) {
            f fVar = (f) ((WeakReference) it.next()).get();
            if (fVar != null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                fVar.onUpdate(emptyList, false);
            }
        }
    }
}

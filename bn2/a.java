package bn2;

import an2.b;
import an2.c;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.ItemType;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J$\u0010\u0007\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u00040\u00030\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0006H&J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016R)\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00160\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR2\u0010\"\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u00040\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!\u00a8\u0006%"}, d2 = {"Lbn2/a;", "", "Landroidx/lifecycle/MutableLiveData;", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/richmedialist/model/ItemType;", "Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", "e", "Landroid/content/Context;", "context", "itemType", "Lan2/c;", "operatorListener", "", h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "a", "itemInfo", "", "d", "i", "type", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "f", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "g", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "()Ljava/util/concurrent/ConcurrentHashMap;", "businessMap", "Landroidx/lifecycle/MutableLiveData;", "listLiveData", "<init>", "()V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<ItemType, AsyncListDifferDelegationAdapter<BaseItemInfo>> businessMap = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<Pair<ItemType, List<BaseItemInfo>>>> listLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: bn2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public /* synthetic */ class C0138a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28693a;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.DIRECTORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28693a = iArr;
        }
    }

    @NotNull
    public abstract RFWConcatAdapter a();

    public void b() {
        this.businessMap.clear();
    }

    @NotNull
    public final ConcurrentHashMap<ItemType, AsyncListDifferDelegationAdapter<BaseItemInfo>> c() {
        return this.businessMap;
    }

    public abstract int d(@NotNull BaseItemInfo itemInfo);

    @NotNull
    public final MutableLiveData<List<Pair<ItemType, List<BaseItemInfo>>>> e() {
        return this.listLiveData;
    }

    @Nullable
    public final AsyncListDifferDelegationAdapter<BaseItemInfo> f(@NotNull ItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.businessMap.get(type);
    }

    public void g(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
    }

    public final void h(@NotNull Context context, @NotNull ItemType itemType, @NotNull c operatorListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(operatorListener, "operatorListener");
        int i3 = C0138a.f28693a[itemType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                RFWIocAbilityProvider.g().registerGlobalIoc(context, operatorListener, b.class);
                return;
            }
            return;
        }
        RFWIocAbilityProvider.g().registerGlobalIoc(context, operatorListener, an2.a.class);
    }

    public final void i(@NotNull BaseItemInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        AsyncListDifferDelegationAdapter<BaseItemInfo> f16 = f(itemInfo.getItemType());
        if (f16 != null) {
            f16.notifyItemChanged(d(itemInfo));
        }
    }
}

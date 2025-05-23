package oe1;

import android.util.SparseArray;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.guild.aio.component.combinestyle.ah;
import com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.LoadImageStrategyFromMedia;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\f"}, d2 = {"Loe1/a;", "", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/component/combinestyle/af;", "b", "a", "Landroid/util/SparseArray;", "guildMediaOnlineMsgItemComponentArray", "c", "guildLiveOnlineMsgItemComponentArray", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f422573a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<af> guildMediaOnlineMsgItemComponentArray;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<af> guildLiveOnlineMsgItemComponentArray;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"oe1/a$a", "Lkotlin/Function1;", "", "Lcom/tencent/guild/aio/component/combinestyle/ah;", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oe1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C10904a implements Function1<Integer, ah> {
        C10904a() {
        }

        @NotNull
        public ah a(int materialId) {
            return new com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy.a(Integer.valueOf(materialId), null, null, 0, 0, 30, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ah invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"oe1/a$b", "Lkotlin/Function1;", "", "Lcom/tencent/guild/aio/component/combinestyle/ah;", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements Function1<Integer, ah> {
        b() {
        }

        @NotNull
        public ah a(int materialId) {
            return new LoadImageStrategyFromMedia(Integer.valueOf(materialId), null, null, 0, 0, 30, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ah invoke(Integer num) {
            return a(num.intValue());
        }
    }

    static {
        SparseArray<af> sparseArray = new SparseArray<>();
        sparseArray.put(14, new pe1.a(new b()));
        guildMediaOnlineMsgItemComponentArray = sparseArray;
        SparseArray<af> sparseArray2 = new SparseArray<>();
        sparseArray2.put(14, new pe1.a(new C10904a()));
        sparseArray2.put(com.tencent.mobileqq.guild.message.a.f230108a.b(), new pe1.b());
        guildLiveOnlineMsgItemComponentArray = sparseArray2;
    }

    a() {
    }

    @NotNull
    public final SparseArray<af> a() {
        return guildLiveOnlineMsgItemComponentArray;
    }

    @NotNull
    public final SparseArray<af> b() {
        return guildMediaOnlineMsgItemComponentArray;
    }
}

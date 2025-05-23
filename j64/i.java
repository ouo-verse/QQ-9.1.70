package j64;

import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.slash.dialog.search.SearchException;
import j64.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\f\u001a\u00020\u0004R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001d\u00a8\u0006!"}, d2 = {"Lj64/i;", "", "Lj64/g;", "search", "", "f", "searchContext", "g", "e", "", "throwable", "d", "a", "Lj64/h;", "Lj64/h;", "c", "()Lj64/h;", "mSearchResultListener", "", "b", "Z", "()Z", "setMCancel", "(Z)V", "mCancel", "Lj64/g;", "mCurrentSearch", "Landroid/util/LruCache;", "", "Landroid/util/LruCache;", "mSearchCache", "<init>", "(Lj64/h;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h mSearchResultListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mCancel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mCurrentSearch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, g> mSearchCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"j64/i$b", "Lj64/g$b;", "Lj64/g;", "searchContext", "Lcom/tencent/robot/slash/dialog/search/SearchException;", "e", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements g.b {
        b() {
        }

        @Override // j64.g.b
        public void a(@NotNull g searchContext, @Nullable SearchException e16) {
            Intrinsics.checkNotNullParameter(searchContext, "searchContext");
            if (e16 == null) {
                i.this.e(searchContext);
            } else {
                i.this.d(e16);
            }
        }
    }

    public i(@NotNull h mSearchResultListener) {
        Intrinsics.checkNotNullParameter(mSearchResultListener, "mSearchResultListener");
        this.mSearchResultListener = mSearchResultListener;
        this.mSearchCache = new LruCache<>(10);
    }

    public final void a() {
        this.mSearchCache.evictAll();
        this.mCurrentSearch = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: from getter */
    public final boolean getMCancel() {
        return this.mCancel;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final h getMSearchResultListener() {
        return this.mSearchResultListener;
    }

    public void d(@NotNull Throwable throwable) {
        g gVar;
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if ((throwable instanceof SearchException) && !this.mCancel) {
            SearchException searchException = (SearchException) throwable;
            if (!searchException.getSearchContext().e() && (gVar = this.mCurrentSearch) != null && gVar == searchException.getSearchContext()) {
                QLog.w("SearchSession", 1, "cookieKey: " + searchException.getSearchContext().c() + " errorCode: " + searchException.getErrorCode() + " errorMsg: " + searchException.getErrorMsg());
                this.mSearchResultListener.d(searchException.getSearchContext(), searchException.getErrorMsg(), searchException.getErrorCode());
            }
        }
    }

    protected void e(@NotNull g searchContext) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@NotNull g search) {
        Intrinsics.checkNotNullParameter(search, "search");
        String c16 = search.c();
        g gVar = this.mSearchCache.get(c16);
        if (gVar != null && gVar.f()) {
            if (!gVar.g()) {
                this.mCurrentSearch = gVar;
                e(gVar);
                return;
            }
            this.mSearchCache.remove(c16);
        }
        g(search);
    }

    protected void g(@NotNull g searchContext) {
        Intrinsics.checkNotNullParameter(searchContext, "searchContext");
        this.mSearchCache.put(searchContext.c(), searchContext);
        this.mCurrentSearch = searchContext;
        searchContext.i(new b());
    }
}

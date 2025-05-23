package kotlin;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\u000b\u001a\u00020\u0004*\u00020\u00062!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u0007H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lsg1/f;", "", "", "isNightTheme", "", "d", "Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "observer", "f", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "c", "()Z", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "nightThemeLiveData", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f433786a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Boolean> nightThemeLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"sg1/f$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Observer<Boolean> f433788d;

        a(Observer<Boolean> observer) {
            this.f433788d = observer;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            Integer num;
            C11734b c11734b = C11734b.f433780a;
            if (QLog.isColorLevel()) {
                String str = "Guild.component.ThemeUtil";
                if (v3 != null) {
                    num = Integer.valueOf(v3.hashCode());
                } else {
                    num = null;
                }
                QLog.w(str, 2, "onViewAttachedToWindow: " + num, null);
            }
            f.nightThemeLiveData.observeForever(this.f433788d);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            Integer num;
            C11734b c11734b = C11734b.f433780a;
            if (QLog.isColorLevel()) {
                String str = "Guild.component.ThemeUtil";
                if (v3 != null) {
                    num = Integer.valueOf(v3.hashCode());
                } else {
                    num = null;
                }
                QLog.w(str, 2, "onViewDetachedFromWindow: " + num, null);
            }
            f.nightThemeLiveData.removeObserver(this.f433788d);
        }
    }

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Ref.BooleanRef isNightThemeLastly, Function1 observer, View this_observeNightTheme, Boolean it) {
        Intrinsics.checkNotNullParameter(isNightThemeLastly, "$isNightThemeLastly");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        Intrinsics.checkNotNullParameter(this_observeNightTheme, "$this_observeNightTheme");
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.ThemeUtil", 1, "observeNightTheme changed(" + this_observeNightTheme.hashCode() + "): last:" + isNightThemeLastly.element + ", current:" + it, null);
        if (!Intrinsics.areEqual(Boolean.valueOf(isNightThemeLastly.element), it)) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            isNightThemeLastly.element = it.booleanValue();
            observer.invoke(it);
        }
    }

    public final boolean c() {
        Boolean value = nightThemeLiveData.getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    public final void d(boolean isNightTheme) {
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.ThemeUtil", 1, "notifyNightThemeChanged(" + isNightTheme + ")", null);
        nightThemeLiveData.setValue(Boolean.valueOf(isNightTheme));
    }

    public final void f(@NotNull final View view, @NotNull final Function1<? super Boolean, Unit> observer) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        C11734b c11734b = C11734b.f433780a;
        int hashCode = view.hashCode();
        MutableLiveData<Boolean> mutableLiveData = nightThemeLiveData;
        QLog.i("Guild.component.ThemeUtil", 1, "observeNightTheme(" + hashCode + "): " + mutableLiveData.getValue(), null);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Boolean value = mutableLiveData.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        booleanRef.element = booleanValue;
        observer.invoke(Boolean.valueOf(booleanValue));
        Observer<? super Boolean> observer2 = new Observer() { // from class: sg1.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.e(Ref.BooleanRef.this, observer, view, (Boolean) obj);
            }
        };
        if (view.isAttachedToWindow()) {
            if (QLog.isColorLevel()) {
                QLog.w("Guild.component.ThemeUtil", 2, "isAttachedToWindow: " + view.hashCode(), null);
            }
            mutableLiveData.observeForever(observer2);
        }
        view.addOnAttachStateChangeListener(new a(observer2));
    }
}

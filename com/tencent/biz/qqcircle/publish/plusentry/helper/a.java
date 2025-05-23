package com.tencent.biz.qqcircle.publish.plusentry.helper;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R(\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\b\u0010\t\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0011\u0010\u0017R \u0010 \u001a\u00020\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\u0004\u0018\u00010\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\"\u0010\u000e\u001a\u0004\b\u0004\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/helper/a;", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "b", "Ljava/lang/ref/WeakReference;", "plusEntryLayoutRef", "", "c", "Z", "()Z", "setShowPlusEntry", "(Z)V", "isShowPlusEntry$annotations", "()V", "isShowPlusEntry", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "_isShowPlusEntryObservable", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "isShowPlusEntryObservable$annotations", "isShowPlusEntryObservable", "Lcom/tencent/biz/qqcircle/publish/plusentry/helper/PlusEntryExp;", "f", "Lcom/tencent/biz/qqcircle/publish/plusentry/helper/PlusEntryExp;", "a", "()Lcom/tencent/biz/qqcircle/publish/plusentry/helper/PlusEntryExp;", "getExp$annotations", "exp", "()Landroid/view/View;", "getPlusEntryLayout$annotations", "plusEntryLayout", "<init>", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f91742a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile WeakReference<View> plusEntryLayoutRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isShowPlusEntry;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Boolean> _isShowPlusEntryObservable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LiveData<Boolean> isShowPlusEntryObservable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final PlusEntryExp exp;

    static {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        _isShowPlusEntryObservable = mutableLiveData;
        isShowPlusEntryObservable = mutableLiveData;
        exp = PlusEntryExp.EXP_C;
    }

    a() {
    }

    @NotNull
    public static final PlusEntryExp a() {
        return exp;
    }

    @Nullable
    public static final View b() {
        WeakReference<View> weakReference = plusEntryLayoutRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static final boolean c() {
        return isShowPlusEntry;
    }

    @NotNull
    public static final LiveData<Boolean> d() {
        return isShowPlusEntryObservable;
    }
}

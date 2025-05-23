package com.tencent.qqnt.chats.core.ui.third;

import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.ui.third.p013const.RelativeEnum;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010%BG\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b$\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b\u0010\u0010 \"\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "a", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "d", "()Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "viewType", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "extra", "", "Lcom/tencent/qqnt/chats/core/ui/third/const/RelativeEnum;", "c", "Ljava/util/List;", "()Ljava/util/List;", "setRelativeList", "(Ljava/util/List;)V", "relativeList", "Landroid/view/ViewGroup$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "()Landroid/view/ViewGroup$LayoutParams;", "e", "(Landroid/view/ViewGroup$LayoutParams;)V", "layoutParams", "<init>", "(Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;)V", "(Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;Ljava/util/Map;Ljava/util/List;Landroid/view/ViewGroup$LayoutParams;)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ThirdViewEnum viewType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, ? extends Object> extra;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends RelativeEnum> relativeList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup.LayoutParams layoutParams;

    public f(@NotNull ThirdViewEnum viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.viewType = viewType;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewType);
        }
    }

    @Nullable
    public final Map<String, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.extra;
    }

    @Nullable
    public final ViewGroup.LayoutParams b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.layoutParams;
    }

    @Nullable
    public final List<RelativeEnum> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.relativeList;
    }

    @NotNull
    public final ThirdViewEnum d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ThirdViewEnum) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.viewType;
    }

    public final void e(@Nullable ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) layoutParams);
        } else {
            this.layoutParams = layoutParams;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof f) && this.viewType == ((f) other).viewType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.viewType.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "ThirdContainerParams(viewType=" + this.viewType + ")";
    }

    public /* synthetic */ f(ThirdViewEnum thirdViewEnum, Map map, List list, ViewGroup.LayoutParams layoutParams, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(thirdViewEnum, (i3 & 2) != 0 ? null : map, (i3 & 4) == 0 ? list : null, (i3 & 8) != 0 ? new ViewGroup.LayoutParams(-2, -2) : layoutParams);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, this, thirdViewEnum, map, list, layoutParams, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@NotNull ThirdViewEnum viewType, @Nullable Map<String, ? extends Object> map, @Nullable List<? extends RelativeEnum> list, @Nullable ViewGroup.LayoutParams layoutParams) {
        this(viewType);
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, viewType, map, list, layoutParams);
            return;
        }
        this.extra = map;
        this.relativeList = list;
        this.layoutParams = layoutParams;
    }
}
